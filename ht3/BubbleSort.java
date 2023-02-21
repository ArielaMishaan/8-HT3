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
	 * @param arreglo
	 * @param comparador
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
