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

public class Radix <T>{

    // Using counting sort to sort the elements in the basis of significant places
    public void countingSort(T MyArray[], int size, int place, Comparator<T> myCompare) {
        T[] output = (T[]) new Object[size + 1];
        T max = MyArray[0];
        T actual = MyArray[0];
        int act = 0;
        for (int i = 1; i < size; i++) {
            actual = MyArray[i];
            if (myCompare.compare(actual, max) >= 0)
                max = actual;
        }
        int maximo = Integer.valueOf((String) max);
        int[] count = new int[maximo + 1];

        for (int i = 0; i < maximo; ++i)
        count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            actual = MyArray[i];
            act = Integer.valueOf((String) actual);
            count[(act / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            actual = MyArray[i];
            act = Integer.valueOf((String) actual);
            output[count[(act / place) % 10] - 1] = MyArray[i];
            count[(act / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            MyArray[i] = output[i];
    }

    // Function to get the largest element from an array
    public T getMax(T MyArray[], int n, Comparator<T> myCompare) {
        T max = MyArray[0];
        T actual = MyArray[0];
        for (int i = 1; i < n; i++)
            actual = MyArray[i];
            if (myCompare.compare(actual, max) >= 0)
                max = actual;
        return max;
    }

    // Main function to implement radix sort
    public void radixSort(T MyArray[], int size, Comparator<T> myCompare) {
        // Get maximum element
        T max = getMax(MyArray, size, myCompare);
        int maximo = Integer.valueOf((String) max);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; maximo / place > 0; place *= 10)
        countingSort(MyArray, size, place, myCompare);
    }


}
