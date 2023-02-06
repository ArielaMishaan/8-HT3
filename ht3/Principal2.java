import java.util.ArrayList;
import java.util.Scanner;
/*
* Alina Carías (22539), Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto (22737)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 3
 * 03-02-2023
 * Clase Princiapl: Es la clase que interactua con el usuario y permite que todos los sorts se puedan visualizar.
 */

public class Principal2 {
    
    /** 
     * @param args 
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        Archivo archivo = new Archivo("numeros.txt");
        //Archivo archivoOrdenado = new Archivo("numerosOrdenados.txt");
         
        System.out.println("\n¿Desea generar números aleatorios (1) o probar el ordenamiento con el archivo ya ordenado (2)?");
        boolean entradaIncorrecta1 = true;
        int opcion = 0;
        int cantidad = 0;
        
        while(entradaIncorrecta1){
            try{
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\n¿Cuántos valores desea generar? (Máximo 3000)");
                        boolean entradaIncorrecta = true;
                        
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
                                teclado.nextLine();
                                System.out.println("\nIngrese un número válido.");
                                // TODO: handle exception
                            }
                        }
                
                
                        for (int i = 0; i < cantidad; i ++){
                            int valor = (int) Math.floor(Math.random() * (1000));
                            String valorString = String.valueOf(valor);
                            archivo.escribirArchivo2(valorString + "\n");
                        }


                        ArrayList<String> lineas = archivo.leerArchivo();
        
                        Integer[] valores = new Integer[cantidad];
                        Integer[] valoresQuicksort = new Integer [cantidad];
                        Integer[] valoresGnomeSort = new Integer[cantidad];
                        Integer[] valoresMergeSort = new Integer[cantidad];
                        Integer[] valoresRadix = new Integer[cantidad];
                        
                        for (int i = 0; i < cantidad; i++) {
                            valores[i] = Integer.valueOf(lineas.get(i));
                            valoresQuicksort[i] = Integer.valueOf(lineas.get(i));
                            valoresGnomeSort[i] = Integer.valueOf(lineas.get(i));
                            valoresMergeSort[i] = Integer.valueOf(lineas.get(i));
                            valoresRadix[i] = Integer.valueOf(lineas.get(i));
                        }

                        System.out.println("\nNÚMEROS DESORDENADOS: ");

                        for(int i = 0; i < valores.length; i++){
                            System.out.println("[" + i + "] => " + valores[i]);
                        }

                        //Comparación usando BubbleSort
                        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();

                        System.out.println("\nORDENANDO...");
                        bubbleSort.sort(valores, new ComparadorEnteros<Integer>());
                        System.out.println("\nNÚMEROS ORDENADOS BUBBLE SORT: ");
                        
                        for(int i = 0; i < valores.length; i++){
                            System.out.println("[" + i + "] => " + valores[i]);
                        }

                        System.out.println("\nPresione una tecla para continuar con quicksort.");
                        teclado.nextLine();

                        //Comparación usando QuickSort

                        QuickSort<Integer> quickSort = new QuickSort<Integer>();

                        System.out.println("\nORDENANDO...");
                        quickSort.quickSort(valoresQuicksort, 0, valoresQuicksort.length - 1, new ComparadorEnteros<Integer>());
                        System.out.println("\nNÚMEROS ORDENADOS QUICKSORT: ");
                        
                        for(int i = 0; i < valoresQuicksort.length; i++){
                            System.out.println("[" + i + "] => " + valoresQuicksort[i]);
                        }

                        //Comparación usando GnomeSort
                        
                        GnomeSort<Integer> gnomeSort = new GnomeSort<Integer>();

                        System.out.println("\nORDENANDO...");
                        gnomeSort.gnomeSort(valoresGnomeSort, new ComparadorEnteros<Integer>(), valoresGnomeSort.length);
                        System.out.println("\nNÚMEROS ORDENADOS GNOMESORT: ");
                        
                        for(int i = 0; i < valoresGnomeSort.length; i++){
                            System.out.println("[" + i + "] => " + valoresGnomeSort[i]);
                        }

                        //Comparación usando MergeSort

                        MergeSort<Integer> mergeSort = new MergeSort<Integer>();
                        
                        System.out.println("\nORDENANDO...");
                        mergeSort.mergeSort(valoresMergeSort, 0, valoresMergeSort.length-1);
                        System.out.println("\nNÚMEROS ORDENADOS MERGESORT: ");
                        
                        for(int i = 0; i < valoresMergeSort.length; i++){
                            System.out.println("[" + i + "] => " + valoresMergeSort[i]);
                        }

                        //Comparación usando RadixSort

                        Radix<Integer> radixSort = new Radix<Integer>();

                        System.out.println("\nORDENANDO...");
                        radixSort.radixSort(valoresRadix, valoresRadix.length, new ComparadorEnteros<Integer>());
                        System.out.println("\nNÚMEROS ORDENADOS RADIXSORT: ");
                        
                        for(int i = 0; i < valoresRadix.length; i++){
                            System.out.println("[" + i + "] => " + valoresRadix[i]);
                        }
                        
                        archivo.escribirArchivo("");

                        for (Integer numero : valores) {
                            archivo.escribirArchivo2(String.valueOf(numero) + "\n");
                        }
                        entradaIncorrecta1 = false;
                        break;
                    
                    case 2:
                        System.out.println("\n¿Cuántos valores tiene su archivo? (Máximo 3000)");
                        boolean entradaIncorrecta3 = true;
                        
                        while (entradaIncorrecta3) {
                            try {
                                cantidad = teclado.nextInt();
                
                                if(cantidad > 3000){
                                    System.out.println("\nIngrese un número válido.");
                                }
                                else{
                                    entradaIncorrecta3 = false;
                                }
                                
                            } catch (Exception e) {
                                teclado.nextLine();
                                System.out.println("\nIngrese un número válido.");
                                // TODO: handle exception
                            }
                            System.out.println("\n¿Cuántos valores desea generar? (Máximo 3000)");
                        }

                        ArrayList<String> lineas2 = archivo.leerArchivo();
                        
                        Integer[] valores2 = new Integer[cantidad];
                        Integer[] valoresQuicksort2 = new Integer [cantidad];
                        Integer[] valoresGnomeSort2 = new Integer[cantidad];
                        Integer[] valoresMergeSort2 = new Integer[cantidad];
                        Integer[] valoresRadix2 = new Integer[cantidad];
                        
                        for (int i = 0; i < cantidad; i++) {
                            valores2[i] = Integer.valueOf(lineas2.get(i));
                            valoresQuicksort2[i] = Integer.valueOf(lineas2.get(i));
                            valoresGnomeSort2[i] = Integer.valueOf(lineas2.get(i));
                            valoresMergeSort2[i] = Integer.valueOf(lineas2.get(i));
                            valoresRadix2[i] = Integer.valueOf(lineas2.get(i));
                        }

                        System.out.println("\nNÚMEROS DESORDENADOS: ");

                        for(int i = 0; i < valores2.length; i++){
                            System.out.println("[" + i + "] => " + valores2[i]);
                        }

                        //Comparación usando BubbleSort
                        BubbleSort<Integer> bubbleSort2 = new BubbleSort<Integer>();

                        System.out.println("\nORDENANDO...");
                        bubbleSort2.sort(valores2, new ComparadorEnteros<Integer>());
                        System.out.println("\nNÚMEROS ORDENADOS BUBBLE SORT: ");
                        
                        for(int i = 0; i < valores2.length; i++){
                            System.out.println("[" + i + "] => " + valores2[i]);
                        }

                        System.out.println("\nPresione una tecla para continuar con quicksort.");
                        teclado.nextLine();

                        //Comparación usando QuickSort

                        QuickSort<Integer> quickSort2 = new QuickSort<Integer>();

                        System.out.println("\nORDENANDO...");
                        quickSort2.quickSort(valoresQuicksort2, 0, valoresQuicksort2.length - 1, new ComparadorEnteros<Integer>());
                        System.out.println("\nNÚMEROS ORDENADOS QUICKSORT: ");
                        
                        for(int i = 0; i < valoresQuicksort2.length; i++){
                            System.out.println("[" + i + "] => " + valoresQuicksort2[i]);
                        }

                        //Comparación usando GnomeSort
                        
                        GnomeSort<Integer> gnomeSort2 = new GnomeSort<Integer>();

                        System.out.println("\nORDENANDO...");
                        gnomeSort2.gnomeSort(valoresGnomeSort2, new ComparadorEnteros<Integer>(), valoresGnomeSort2.length);
                        System.out.println("\nNÚMEROS ORDENADOS GNOMESORT: ");
                        
                        for(int i = 0; i < valoresGnomeSort2.length; i++){
                            System.out.println("[" + i + "] => " + valoresGnomeSort2[i]);
                        }

                        //Comparación usando MergeSort

                        MergeSort<Integer> mergeSort2 = new MergeSort<Integer>();
                        
                        System.out.println("\nORDENANDO...");
                        mergeSort2.mergeSort(valoresMergeSort2, 0, valoresMergeSort2.length-1);
                        System.out.println("\nNÚMEROS ORDENADOS MERGESORT: ");
                        
                        for(int i = 0; i < valoresMergeSort2.length; i++){
                            System.out.println("[" + i + "] => " + valoresMergeSort2[i]);
                        }

                        //Comparación usando RadixSort

                        Radix<Integer> radixSort2 = new Radix<Integer>();

                        System.out.println("\nORDENANDO...");
                        radixSort2.radixSort(valoresRadix2, valoresRadix2.length, new ComparadorEnteros<Integer>());
                        System.out.println("\nNÚMEROS ORDENADOS RADIXSORT: ");
                        
                        for(int i = 0; i < valoresRadix2.length; i++){
                            System.out.println("[" + i + "] => " + valoresRadix2[i]);
                        }
                        
                        archivo.escribirArchivo("");

                        for (Integer numero : valores2) {
                            archivo.escribirArchivo2(String.valueOf(numero) + "\n");
                        }
                        entradaIncorrecta1 = false;
                        break;

                    default:
                        teclado.nextLine();
                        System.out.println("\nIngrese un número válido.");
                        break;
                }
            }
            catch (Exception e){
                teclado.nextLine();
                System.out.println("\nIngrese un número válido.");
                // TODO: handle exception
            }
        }

    }
}
