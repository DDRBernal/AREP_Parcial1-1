/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arem.punto1;

/**
 *
 * @author arep02
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class HttpServer {

    private static TrigCalculator trigCalculator = new TrigCalculator();

    public static void run() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        Socket clientSocket = null;
        boolean running = true;
        while (running) {
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine, message = "";
            int value = 0;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("GET")) {
                    message = inputLine.split(" ")[1];
                }
                System.out.println("Recibí: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }

            //example: if url is localhost/35000/"cos"||"sin"||"tan"?val=number
            //example  if url is localhost:35000/qck/{5,2,8,1}"
            String result = "";
            if (message.contains("cos") || message.contains("sin") || message.contains("tan")){
                String operator = message.split("/")[1];
                try {
                    value = Integer.parseInt(message.split("val=")[1]);
                } catch (NumberFormatException ex){
                    operator = "-404_error";
                }
                trigCalculator.setValues(operator,value);
                System.out.println(trigCalculator.getValor());
                if (operator!="-404_error") result = TrigCalculator.convertoToJSON(String.valueOf(trigCalculator.calculoRadianes()));
                else {result="Incorrect operator or invalid number";}

            }
            //Quicksort
            else if (message.contains("qck")){
                String operator = message.split("/")[1];
                String values = message.split("val=")[1];
                try {
                    trigCalculator.setValues(operator,values);
                } catch (NumberFormatException ex ){
                    values = "-404_error";
                }
                if (values!="-404_error") {
                    ArrayList<Integer> arrayTemp = trigCalculator.quicksort();
                    result = "{";
                    for (Integer i : arrayTemp) {
                        result += i.toString() + ",";
                    }
                    result += "}";
                } else{
                    result="Incorrect operator or invalid number";
                }
            } else{
                result = "Not a valid operator";
            }


            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/JSON\r\n"
                    + "\r\n"
                    + "JSON: \n" + result;


//            outputLine = "HTTP/1.1 200 OK\r\n"
//                    + "Content-Type: text/html\r\n"
//                    + "\r\n"
//                    + "<!DOCTYPE html>\n"
//                    + "<html>\n"
//                    + "<head>\n"
//                    + "<meta charset=\"UTF-8\">\n"
//                    + "<title>Title of the document</title>\n"
//                    + "</head>\n"
//                    + "<body>\n"
//                    + "<h1>Mi propio mensaje</h1>\n" +ReadFile.readfile()
//                    + "</body>\n"
//                    + "</html>\n";


            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }
    
    public void readFile(){
        String outputLine = "HTTP/1.1 200 OK\r\n"
        + "Content-Type: text/html\r\n"
         + "\r\n"
         + "<!DOCTYPE html>\n"
         + "<html>\n"
         + "<head>\n"
         + "<meta charset=\"UTF-8\">\n"
         + "<title>Title of the document</title>\n"
         + "</head>\n"
         + "<body>\n"
         + "<h1>Mi propio mensaje</h1>\n"
         + "</body>\n"
         + "</html>\n";
    
        
    }
    
    /**
     * Return the port
     * @return 
     */
    public static int getPort(){
        int port = 35000;
        if (System.getenv("PORT")!=null){
            port = new Integer(System.getenv("PORT"));
        }
        return port;
    }
}
