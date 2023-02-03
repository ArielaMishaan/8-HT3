//package ht3;
import java.util.Comparator;

class MergeSortGeneric<T extends Comparable<? super T>> {
    public static void main(String[] args)
    {
        // example using Strings
        String[]                 arrayOfStrings = {"Andree", "Leana", "Faviola", "Loyce", "Quincy", "Milo", "Jamila", "Toccara", "Nelda", "Blair", "Ernestine", "Chara", "Kareen", "Monty", "Rene", "Cami", "Winifred", "Tara", "Demetrice", "Azucena"};
        MergeSortGeneric<String> stringSorter   = new MergeSortGeneric<>();
        stringSorter.mergeSort(arrayOfStrings, 0, arrayOfStrings.length - 1);
        System.out.println(java.util.Arrays.toString(arrayOfStrings));

        // example using Doubles
        Double[]                 arrayOfDoubles = {0.35, 0.02, 0.36, 0.82, 0.27, 0.49, 0.41, 0.17, 0.30, 0.89, 0.37, 0.66, 0.82, 0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};
        MergeSortGeneric<Double> doubleSorter   = new MergeSortGeneric<>();
        doubleSorter.mergeSort(arrayOfDoubles, 0, arrayOfDoubles.length - 1);
        System.out.println(java.util.Arrays.toString(arrayOfDoubles));
    }

    // main function that sorts array[start..end] using merge()
    void mergeSort(T[] array, int start, int end)
    {
        // base case
        if (start < end)
        {
            // find the middle point
            int middle = (start + end) / 2;

            mergeSort(array, start, middle); // sort first half
            mergeSort(array, middle + 1, end);  // sort second half

            // merge the sorted halves
            merge(array, start, middle, end);
        }
    }

    // merges two subarrays of array[].
    void merge(T[] array, int start, int middle, int end)
    {
        T[] leftArray  = (T[]) new Comparable[middle - start + 1];
        T[] rightArray = (T[]) new Comparable[end - middle];

        // fill in left array
        for (int i = 0; i < leftArray.length; ++i)
            leftArray[i] = array[start + i];

        // fill in right array
        for (int i = 0; i < rightArray.length; ++i)
            rightArray[i] = array[middle + 1 + i];

        /* Merge the temp arrays */

        // initial indexes of first and second subarrays
        int leftIndex = 0, rightIndex = 0;

        // the index we will start at when adding the subarrays back into the main array
        int currentIndex = start;

        // compare each index of the subarrays adding the lowest value to the currentIndex
        while (leftIndex < leftArray.length && rightIndex < rightArray.length)
        {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0)
            {
                array[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            }
            else
            {
                array[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

        // copy remaining elements of leftArray[] if any
        while (leftIndex < leftArray.length) array[currentIndex++] = leftArray[leftIndex++];

        // copy remaining elements of rightArray[] if any
        while (rightIndex < rightArray.length) array[currentIndex++] = rightArray[rightIndex++];
    }
}



/*

public class MergeSort <T> {  
  
public void merge(T[] arreglo,Comparator<T> myCompare, int inicio, int mid, int fin)    
{    
    int i, j, k;  
    int n1 = mid - inicio + 1;    
    int n2 = fin - mid;    
    T temp = null;
      
    T LeftArray[] = new [n1];  
    int RightArray[] = new int[n2];  
      
    for (i = 0; i < n1; i++)    
    LeftArray[i] = arreglo[inicio + i];    
    for (j = 0; j < n2; j++)    
    RightArray[j] = arreglo[mid + 1 + j];    
      
    i = 0;  
    j = 0; 
    k = inicio;
      
    while (i < n1 && j < n2)    
    {    
        if(LeftArray[i] <= RightArray[j])    
        {    
            arreglo[k] = LeftArray[i];    
            i++;    
        }    
        else    
        {    
            arreglo[k] = RightArray[j];    
            j++;    
        }    
        k++;    
    }    
    while (i<n1)    
    {    
        arreglo[k] = LeftArray[i];    
        i++;    
        k++;    
    }    
      
    while (j<n2)    
    {    
        arreglo[k] = RightArray[j];    
        j++;    
        k++;    
    }    
}    
  
void mergeSort(int a[], int inicio, int fin)  
{  
    if (inicio < fin)   
    {  
        T temp = null;
        int mid = (inicio + fin) / 2;  
        mergeSort(a, inicio, mid);  
        mergeSort(a, mid + 1, fin);  
        merge(arreglo, myComparator,  inicio, mid, fin);  
    }  
}  
  
void printArray(int a[], int n)  
{  
    int i;  
    for (i = 0; i < n; i++)  
        System.out.print(a[i] + " ");  
}  
 
/* 
 * 
 public static void main(String args[])  
 {  
     int a[] = { 11, 30, 24, 7, 31, 16, 39, 41 };  
     int n = a.length;  
     Merge m1 = new Merge();  
     System.out.println("\nBefore sorting array elements are - ");  
     m1.printArray(a, n);  
     m1.mergeSort(a, 0, n - 1);  
     System.out.println("\nAfter sorting array elements are - ");  
     m1.printArray(a, n);  
     System.out.println("");  
 }  
*/

