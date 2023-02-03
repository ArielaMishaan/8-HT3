//package ht3;

/*
 * Código obtenido de javaTPoint.com
 */

import java.util.Comparator;

public class MergeSort<T> {  
  
    /* Función para juntar los subarreglos */  
    public void merge(T[] arreglo, Comparator<T> comparador){    
        int i, j, k; 
        int inicio = 0;
        int mitad = (arreglo.length-1)/2;
        int fin = arreglo.length -1;


        int n1 = mitad - inicio + 1;    
        int n2 = fin - mitad;    
        
        /* arreglos temporales */ 
        T[] arregloIzquierdo = (T[]) new Object [n1];
        T[] arregloDerecho = (T[]) new Object [n2]; 

        /* copiar la información en los arreglos temporales */  

        for(i = 0; i< n1; i++){
            arregloIzquierdo[i] = arreglo[i + 1];
        }
        for(j = 0; j < n2; j++){
            arregloDerecho[j] = arreglo[mitad + 1 + j];
        }

        i = 0; /* índice inicial del primer subarreglo*/  
        j = 0; /* índice inicial del segundo subarreglo*/   
        k = inicio;  /* índice inicial del subarreglo unido*/  
        
        while (i < n1 && j < n2){
            
            if(comparador.compare(arregloIzquierdo[i], arregloDerecho[j]) <= 0){
                arreglo[k] = arregloIzquierdo[i];
                i++;
            }
            else{    
                arreglo[k] = arregloDerecho[j];    
                j++;    
            }    

            k++;    
        }  

        while (i<n1){    
            arreglo[k] = arregloIzquierdo[i];    
            i++;    
            k++;    
        }    
        
        while (j<n2)    
        {    
            arreglo[k] = arregloDerecho[j];    
            j++;    
            k++;    
        }
        
        
    }    
    
    void mergeSort(T[] arreglo, Comparator<T> comparador){   
        mergeSort(arreglo, comparador); 
        merge(arreglo, comparador);
          
    }  
  } 

