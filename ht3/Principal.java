//package ht3;
import java.util.Scanner;
//import ht3.*;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
         
        System.out.println("\n¿Cuántos valores desea generar? (Máximo 3000)");
        boolean entradaIncorrecta = true;
        int cantidad = 0;
        
        while (entradaIncorrecta) {
            try {
                cantidad = teclado.nextInt();

                if(cantidad > 3000){
                    System.out.println("\nIngrese un número válido.");
                }
                else{
                    entradaIncorrecta = false;
                }
                
            } catch (Exception e) {
                System.out.println("\nIngrese un número válido.");
                // TODO: handle exception
            }
            System.out.println("\n¿Cuántos valores desea generar? (Máximo 3000)");
        }

        Integer[] valores = new Integer[cantidad];
        Integer[] valoresQuicksort = new Integer [cantidad];

        //Comparación usando BubbleSort

        for (int i = 0; i < cantidad; i++) {
            valores[i] = (int) (Math.floor(Math.random() * (1000)));
        }

        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        System.out.println("\nNÚMEROS DESORDENADOS (BUBBLE SORT)");

        for(int i = 0; i < valores.length; i++){
            System.out.println("[" + i + "] => " + valores[i]);
        }

        System.out.println("ORDENANDO...");
        bubbleSort.sort(valores, new ComparadorEnteros<Integer>());
        System.out.println("\nNÚMEROS ORDENADOS BUBBLE SORT: ");
        
        for(int i = 0; i < valores.length; i++){
            System.out.println("[" + i + "] => " + valores[i]);
        }

        System.out.println("\nPresione una tecla para continuar con quicksort.");
        teclado.nextLine();

        //Comparación usando QuickSort
        
        for (int i = 0; i < cantidad; i++) {
            valoresQuicksort[i] = (int) (Math.floor(Math.random() * (1000)));
        }

        QuickSort<Integer> quickSort = new QuickSort<Integer>();
        System.out.println("\nNÚMEROS DESORDENADOS (QUICKSORT)");

        for(int i = 0; i < valoresQuicksort.length; i++){
            System.out.println("[" + i + "] => " + valoresQuicksort[i]);
        }

        System.out.println("ORDENANDO...");
        quickSort.quickSort(valoresQuicksort, 0, valoresQuicksort.length - 1, new ComparadorEnteros<Integer>());
        System.out.println("\nNÚMEROS ORDENADOS QUICKSORT: ");
        
        for(int i = 0; i < valoresQuicksort.length; i++){
            System.out.println("[" + i + "] => " + valoresQuicksort[i]);
        }

        //Comparación usando MergeSort

        //Comparación usando GnomeSort

        //Comparación usando RadixSort


    }
}
