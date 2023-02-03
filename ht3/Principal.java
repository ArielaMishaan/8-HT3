import java.util.Scanner;
/*
* Alina Carías (22539), Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto (22737)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 3
 * 03-02-2023
 * Clase Princiapl: Es la clase que interactua con el usuario y permite que todos los sorts se puedan visualizar.
 */

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
        Integer[] valoresGnomeSort = new Integer[cantidad];
        Integer[] valoresMergeSort = new Integer[cantidad];
        Integer[] valoresRadix = new Integer[cantidad];


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

        //Comparación usando GnomeSort
        
        for (int i = 0; i < cantidad; i++) {
            valoresGnomeSort[i] = (int) (Math.floor(Math.random() * (1000)));
        }

        GnomeSort<Integer> gnomeSort = new GnomeSort<Integer>();
        System.out.println("\nNÚMEROS DESORDENADOS (GNOMESORT)");

        for(int i = 0; i < valoresGnomeSort.length; i++){
            System.out.println("[" + i + "] => " + valoresGnomeSort[i]);
        }

        System.out.println("ORDENANDO...");
        quickSort.quickSort(valoresGnomeSort, 0, valoresGnomeSort.length - 1, new ComparadorEnteros<Integer>());
        System.out.println("\nNÚMEROS ORDENADOS GNOMESORT: ");
        
        for(int i = 0; i < valoresGnomeSort.length; i++){
            System.out.println("[" + i + "] => " + valoresGnomeSort[i]);
        }


        //Comparación usando MergeSort

        for (int i = 0; i < cantidad; i++) {
            valoresMergeSort[i] = (int) (Math.floor(Math.random() * (1000)));
        }

        MergeSort<Integer> mergeSort = new MergeSort<Integer>();
        System.out.println("\nNÚMEROS DESORDENADOS (MERGESORT)");

        for(int i = 0; i < valoresMergeSort.length; i++){
            System.out.println("[" + i + "] => " + valoresMergeSort[i]);
        }

        System.out.println("ORDENANDO...");
        quickSort.quickSort(valoresMergeSort, 0, valoresMergeSort.length - 1, new ComparadorEnteros<Integer>());
        System.out.println("\nNÚMEROS ORDENADOS MERGESORT: ");
        
        for(int i = 0; i < valoresMergeSort.length; i++){
            System.out.println("[" + i + "] => " + valoresMergeSort[i]);
        }

        //Comparación usando RadixSort

        for (int i = 0; i < cantidad; i++) {
            valoresRadix[i] = (int) (Math.floor(Math.random() * (1000)));
        }

        Radix<Integer> radixSort = new Radix<Integer>();
        System.out.println("\nNÚMEROS DESORDENADOS (RADIXSORT)");

        for(int i = 0; i < valoresRadix.length; i++){
            System.out.println("[" + i + "] => " + valoresRadix[i]);
        }

        System.out.println("ORDENANDO...");
        quickSort.quickSort(valoresRadix, 0, valoresRadix.length - 1, new ComparadorEnteros<Integer>());
        System.out.println("\nNÚMEROS ORDENADOS RADIXSORT: ");
        
        for(int i = 0; i < valoresRadix.length; i++){
            System.out.println("[" + i + "] => " + valoresRadix[i]);
        }

    }
}
