//package ht3;
/*
* Alina Carías (22539), Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto (22737)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 3
 * 03-02-2023
 * Clase Princiapl: Es la clase que interactua con el usuario y permite que todos los sorts se puedan visualizar.
 */
/*
 * Código obtenido de Programiz.com:
 * https://www.programiz.com/java-programming/examples/merge-sort 
 */

import java.util.Comparator;

public class MergeSort<T> {

  
  /** 
   * @param arreglo el arreglo que va a ordenar 
   * @param inicio el inicio del arreglo
   * @param mitad la mitad del arreglo
   * @param fin el último elemento del arreglo
   * @param comparador Un objeto que implementa la clase comparador en la cual se toman que si el primero es menor entonces retorna un número positivo, si es menor negativo y si es igual 0
   */
  // Convertir el arreglo en dos subarreglos: listaIzquierda y listaDerecha
  void merge(T[] arreglo, int inicio, int mitad, int fin, Comparator<T> comparador) {

    int n1 = mitad - inicio + 1;
    int n2 = fin - mitad;
    Comparator <T> comparador2 = new ComparadorEnteros<>();

    T[] listaIzquierda = (T[]) new Object[n1];
    T[] listaDerecha = (T[]) new Object[n2];

    // llenar el arreglo izquierdo y el derecho
    for (int i = 0; i < n1; i++)
      listaIzquierda[i] = (T) arreglo[inicio + i];
    for (int j = 0; j < n2; j++)
      listaDerecha[j] = (T) arreglo[mitad + 1 + j];

    // mantener el índice actual de subarreglos y el arreglo principal 
    int i, j, k;
    i = 0;
    j = 0;
    k = inicio;

    //Hasta que se alcanze el fin del arreglo izquierdo o el del derecho, se escoge un elemento mayor de las dos listas y se pone en la posición correcta.
    while (i < n1 && j < n2) {
      if (comparador.compare(listaIzquierda[i], listaDerecha[j]) <= 0) {
        arreglo[k] = listaIzquierda[i];
        i++;
      } else {
        arreglo[k] = listaDerecha[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arreglo[k] = listaIzquierda[i];
      i++;
      k++;
    }

    while (j < n2) {
      arreglo[k] = listaDerecha[j];
      j++;
      k++;
    }
  }

  //Dividir el arreglo en dso subarreglos, ordenarlos y volverlos a unir. 
  // Divide the array into two sub arrays, sort them and merge them
  public void mergeSort(T[] arreglo, int izquierdo, int derecho) {
    if (izquierdo < derecho) {

      // mid es el punto en el que el arreglo se divide en dos subarreglos 
      int mid = (izquierdo + derecho) / 2;

      // llamada recursiva a cada uno de los subarreglos
      mergeSort(arreglo, izquierdo, mid);
      mergeSort(arreglo, mid + 1, derecho);

      Comparator<T> comparador2 = new ComparadorEnteros();
    // unir los dos arreglos ya ordenados.
      merge(arreglo, izquierdo, mid, derecho, comparador2);
    }
  }
}