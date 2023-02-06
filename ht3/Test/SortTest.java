import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import java.util.Comparator;

/*
 * Alina Carías (22539), Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto (22737)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 2
 * 30-01-2023
 * Clase CalcTest: Pruebas Unitarias
 */


class SortTest {

	BubbleSort<Integer> Bubble = new BubbleSort<Integer>();
	GnomeSort<Integer> Gnome = new GnomeSort<Integer>();
	MergeSort<Integer> Merge = new MergeSort<Integer>();
	QuickSort Quick = new QuickSort<>();
	Radix Radix = new Radix<>();
	Integer[] desordenados = new Integer[3];
	Integer[] ordenados = new Integer[3];
	

	@Test
	void BubbleTest() {
		BubbleSort<Integer> Bubble = new BubbleSort<Integer>();
		Integer[] desordenados = new Integer[3];
		desordenados[0] = Integer.valueOf(2);
		desordenados[1] = Integer.valueOf(1);
		desordenados[2] = Integer.valueOf(3);
		int orden1 = 1;
		int orden2 = 2;
		int orden3 = 3;
		Bubble.sort(desordenados, new ComparadorEnteros<Integer>());
		int primero = desordenados[0];
		int segundo = desordenados[1];
		int tercero = desordenados[2];
		assertEquals(orden1, primero);
		assertEquals(orden2, segundo);
		assertEquals(orden3, tercero);
	}

	@Test
	void GnomeTest() {
		GnomeSort<Integer> Gnome = new GnomeSort<Integer>();
		Integer[] desordenados = new Integer[3];
		desordenados[0] = Integer.valueOf(2);
		desordenados[1] = Integer.valueOf(1);
		desordenados[2] = Integer.valueOf(3);
		int orden1 = 1;
		int orden2 = 2;
		int orden3 = 3;
		Gnome.gnomeSort(desordenados, new ComparadorEnteros<Integer>(), 3);
		int primero = desordenados[0];
		int segundo = desordenados[1];
		int tercero = desordenados[2];
		assertEquals(orden1, primero);
		assertEquals(orden2, segundo);
		assertEquals(orden3, tercero);
	}

	@Test
	void MergeTest() {
		MergeSort<Integer> Merge = new MergeSort<Integer>();
		Integer[] desordenados = new Integer[3];
		desordenados[0] = Integer.valueOf(2);
		desordenados[1] = Integer.valueOf(1);
		desordenados[2] = Integer.valueOf(3);
		int orden1 = 1;
		int orden2 = 2;
		int orden3 = 3;
		Merge.mergeSort(desordenados, 0, 2);
		int primero = desordenados[0];
		int segundo = desordenados[1];
		int tercero = desordenados[2];
		assertEquals(orden1, primero);
		assertEquals(orden2, segundo);
		assertEquals(orden3, tercero);
	}

	@Test
	void QuickTest() {
		QuickSort Quick = new QuickSort<>();
		ArrayList<String> lista =  new ArrayList<>();
		lista.add("7");
		lista.add("9");
		lista.add("*");
		int resultado = calculadora.Calculate(lista);
		assertEquals(63, resultado);
	}

	@Test
	void RadixTest() throws Exception{
		Radix Radix = new Radix<>();
		ArrayList<String> lista =  new ArrayList<>();
		lista.add("6");
		lista.add("24");
		lista.add("/");
		int resultado = calculadora.Calculate(lista);
		assertEquals(4, resultado);
	}

}