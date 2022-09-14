/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arem.punto1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author arep02
 */
public class ReadFile {
    
    public static String readfile() throws IOException{
        String doc = "";
        Path path =  Paths.get("src\\java\\resources\\public\\index.html");
        path.toFile();
//        try(
//
//                InputStream in = new InputStreamReader();
//                BufferedReader buf = new BufferedReader(new InputStreamReader(in.getInputStream()));
//                String inputLine = "";
//        while ((inputLine = buf.readLine()) != null) {
//            System.out.println("Recibí: " + inputLine);
//            doc+=inputLine;
//        } catch (IOException ex){
//
//        }
        return doc;
    }
    
    
}
