/**
 * @author Seccion 40
 *
 * Alina Carías (22539), Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto (22737)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 3
 * 03-02-2023
 * Clase BubbleSort: ordena los elementos con el tipo de BubbleSort.
 */
import java.util.Comparator;

/**
 * @author MAAG
 *
 */
public class BubbleSort<T> {
	
	
	/** 
	 * @param arreglo Este s un arreglo de genéricos, es el que va a ordenar
	 * @param comparador Un objeto que implementa la clase comparador en la cual se toman que si el primero es menor entonces retorna un número positivo, si es menor negativo y si es igual 0
	 */
	public void sort(T[] arreglo, Comparator<T> comparador) {
		for (int i = 0; i < arreglo.length - 1; i++) {
			for (int j = i + 1; j < arreglo.length; j++) {
				if (comparador.compare(arreglo[i], arreglo[j]) > 0) {
					T aux = arreglo[j];
					arreglo[j] = arreglo[i];
					arreglo[i] = aux;
				} 
			}
		}
	}
}
