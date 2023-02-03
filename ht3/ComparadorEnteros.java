//package ht3;
import java.util.Comparator;

/*
* Alina Carías (22539), Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto (22737)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 3
 * 03-02-2023
 * Clase ComparadorEnteros: Compara los numeros puestos para que así los pueda ordenar los sort.
 */

/**
 * @author MAAG
 *
 */
public class ComparadorEnteros<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		//return o1 - o2;
		int numero1 = Integer.parseInt(o1.toString());
		int numero2 = Integer.parseInt(o2.toString());
		if (numero1 > numero2) {
			return 1;
		} else if (numero1 < numero2) {
			return -1;
		} else {
			return 0;
		}
	}

}
