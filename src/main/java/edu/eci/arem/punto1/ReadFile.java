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
        Path file = Paths.get("src\\main\\Resources\\public\\index.html");
        String doc = "";
        try(InputStream in = Files.newInputStream(file);
            BufferedReader buf = new BufferedReader(new InputStreamReader(in))){
            String line = "";
            while((line = buf.readLine())!= null){
                doc+=line;
            }
        } catch (IOException ex){
        }
        return doc;
    }
}