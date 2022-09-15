package edu.eci.arem.punto1;

import java.util.ArrayList;

public class QuickSort {
    private static int fin;
    private static ArrayList<Integer> arrayList;
    private static int inicio;


    public QuickSort(ArrayList<Integer> array){
        arrayList = new ArrayList<>();
        arrayList = array;
        inicio = 0;
        fin = arrayList.size()-1;
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> array, int inicio, int fin){
        ArrayList<Integer> newArray = new ArrayList<>();
        //int pivote =  arrayList.get(fin);
        int index= 0;
        if (inicio< fin){
            Integer[] p = partition(array,inicio,fin);
            for (Integer i : p){
                if (i!=null) {

                }
            }System.out.println();
            ArrayList<Integer> arrayTemp = new ArrayList<>();
            for (Integer i : arrayTemp){
                arrayTemp.add(i);
            }
            ArrayList<Integer> firtArray = sort(arrayTemp, inicio, fin - 1);
            ArrayList<Integer> secondArray = sort(arrayTemp, inicio + 1, fin);
        }
        return newArray;
    }

    public static Integer[] partition(ArrayList<Integer> A, int inicio, int fin){
        Integer[] arrayN = new Integer[fin];
        for (int i = 0; i<A.size(); i++){
            arrayN[i] = A.get(i);
        }
        for (int j = 1; j<A.size(); j++){
            int value1 = arrayN[j];
            int value2 = arrayN[j-1];
            if (value1 > value2){
                int value3 = arrayN[j];
                arrayN[j-1] = value1;
                arrayN[j] = value3;
            }
        }

        return arrayN;
    }


}
/**
 * e. Algoritmo quick sort. El algoritmo de quick sort es una algoritmo recursivo que recibe un arreglo de elementos desordenados us los ordena usando la estrategia de dividir y conquistar. Use un arreglo de. java como estructura de datos. El algoritmo básico es simple:
 * Seleccione como pivote el último elemento del arreglo.
 * Ponga todos los elementos menores que el pivote antes del pivote y todos los elementos mayores al pivote después del pivote.
 * El pivote ya está en su  posición correcta.
 * Ordene cada una de las subcadenas a la derecha e izquierda del pivote.
 * Combine los arreglos ya ordenados.
 *
 * Ejemplo de algoritmo:
 *
 * QUICKSORT (arreglo A, inicio, fin)
 * {
 *   if (inicio < fin)
 *   {
 *      p = partition(A, inicio, fin)
 *      QUICKSORT (A, inicio, p - 1)
 *      QUICKSORT (A, p + 1, fin)
 *  }
 * }
 *
 * El procedimiento "partition" es el que realiza el ordenamiento
 * de los menores y mayores al pivote.
 * Puede implementarlo recorriéndolo una vez e intercambiando posiciones con el pivote.
 */
