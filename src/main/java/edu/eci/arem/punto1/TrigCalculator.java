/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arem.punto1;

import java.util.ArrayList;

/**
 *
 * @author arep02
 */
public class TrigCalculator {

    private String operacion;
    private int valor;
    private ArrayList<Integer> arrayNumbers;
    
    public void setValues(String operacion, int valor){
        this.operacion = operacion;
        this.valor = valor;
    }

    public void setValues(String operacion, String values){
        this.operacion = operacion;
        values = values.replace("{","");
        values = values.replace("}","");
        arrayNumbers = new ArrayList<>();
        for (String number: values.split(",")){
            arrayNumbers.add(Integer.parseInt(number));
        }
    }

    public int getValor(){return valor;}

    public int calculoRadianes(){
        return valor*180;
    }

    public ArrayList<Integer> quicksort(){
        return QuickSort.sort(arrayNumbers,0,arrayNumbers.size());
    }

    public static String convertoToJSON(String value){
        String json = "{" +"\n";
        //if is an array
        System.out.println("json"+value);
        json += "'Result':";
        String[] array = value.split("");
        if (value.contains("{")){
            for (String s : array){
                json+=s+",\n";
            }
        }else {
            json += value + "," + "\n" + "}";
        }
        return json;
    }

    
}
