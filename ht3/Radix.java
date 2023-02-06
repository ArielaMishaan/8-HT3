//package ht3;
import java.util.Comparator;
import java.io.*;
import java.util.*;
// /*
// * Alina Carías (22539), Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto (22737)
//  * Algoritmos y Estructuras de Datos Sección 40
//  * Hoja de Trabajo 3
//  * 03-02-2023
//  * Clase RadixSort: ordena los elementos con el tipo de RadixSort.
//  */

// // Java Program to implement Radix Sort 
// /*
//  * Código tomado de un ejemplo en Programiz en:
//  * https://www.programiz.com/dsa/radix-sort
//  */

public class Radix <T>{

	
	/** 
	 * @param arr[] el arreglo que va a ordenar
	 * @param n 
	 * @param myCompare Un objeto que implementa la clase comparador en la cual se toman que si el primero es menor entonces retorna un número positivo, si es menor negativo y si es igual 0
	 * @return T
	 */
	// A utility function to get maximum value in arr[]
	public T getMax(T arr[], int n, Comparator<T> myCompare)
	{
        T max = arr [0];
        T actual = null;

        for (int i = 1; i < n; i++)
            actual = arr[i];
            if (myCompare.compare(actual, max) >= 0)
                max = actual;
        return max;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	public void countSort(T arr[], int n, int exp, Comparator<T> myCompare)
	{
        T[] output = (T[]) new Object[n];
        int i;
        int[] count = new int[999];
        Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++) count[((int) arr[i] / exp) % 10]++;

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 999; i++) count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[((int) arr[i] / exp) % 10] - 1] = arr[i];
			count[((int) arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current
		// digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	// The main function to that sorts arr[] of
	// size n using Radix Sort
	public void radixSort(T arr[], int n, Comparator<T> myCompare)
	{
		// Find the maximum number to know number of digits
        T max = getMax(arr, n, myCompare);
        int maximo = (int) max;

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = 1; maximo / exp > 0; exp *= 10)
			countSort(arr, n, exp, myCompare);
	}
}
