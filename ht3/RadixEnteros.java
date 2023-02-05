//package ht3;
import java.util.Comparator;
import java.io.*;
import java.util.*;
/*
* Alina Carías (22539), Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto (22737)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 3
 * 03-02-2023
 * Clase RadixSort: ordena los elementos con el tipo de RadixSort.
 */

// Java Program to implement Radix Sort 
/*
 * Código tomado de un ejemplo en Programiz en:
 * https://www.programiz.com/dsa/radix-sort
 */
import java.util.Arrays;


public class RadixEnteros{

    public void countingSort(Integer arreglo[], int size, int lugar){
        Integer[] output = new Integer[size + 1];
        int maximo = arreglo[0];
        for (int i = 1; i < size; i++) {
        if (arreglo[i] > maximo)
            maximo = arreglo[i];
        }
        Integer[] count = new Integer[maximo + 1];

        for (int i = 0; i < maximo; ++i)
        count[i] = 0;

        // Calular la cantidad de elementos 
        for (int i = 0; i < size; i++)
        count[(arreglo[i] / lugar) % 10]++;

        // Calculate la cantidad acumulativa 
        for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];

        // Poner los elementos en orden 
        for (int i = size - 1; i >= 0; i--) {
        output[count[(arreglo[i] / lugar) % 10] - 1] = arreglo[i];
        count[(arreglo[i] / lugar) % 10]--;
        }

        for (int i = 0; i < size; i++)
        arreglo[i] = output[i];
    }

    //función para encontrar el elemento más grande del arreglo
    public int getMax(Integer arreglo[], int n) {
        int max = arreglo[0];
        for (int i = 1; i < n; i++)
            if (arreglo[i] > max)
            max = arreglo[i];
        return max;
    }
    //método principal para implementar el radix sort
    public void radixSort(Integer arreglo[], int tamanio) {
        // encontrar el elemento más grande
        int max = getMax(arreglo, tamanio);

        // aplicar counting sort para ordenar los elementos 
        for (int lugar = 1; max / lugar > 0; lugar *= 10)
        countingSort(arreglo, tamanio, lugar);
    }

}

