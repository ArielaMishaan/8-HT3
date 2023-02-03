//package ht3;
import java.util.Comparator;

// Java Program to implement Gnome Sort
/*
 * Code Contributed by Mohit Gupta_OMG
 * Código tomado de un ejemplo en GeeksForGeeks.org en:
 * https://www.geeksforgeeks.org/java-program-for-gnome-sort/
 * 
 * 
 */

import java.util.Arrays;
public class GnomeSort <T> {

    public void gnomeSort(T[] arreglo, Comparator<T> comparador, int num){
    int index = 0;

    while (index < num) {
    if (index == 0)
        index++;

    if(comparador.compare(arreglo[index], arreglo[index-1])>= 0){
        index ++;
    }

    else {
        T temp = null;
        temp = arreglo[index];
        arreglo[index] = arreglo[index - 1];
        arreglo[index - 1] = temp;
        index--;
    }
    }
    return;
    }
}


