import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/*
 * Alina Carías (22539), Ignacio Méndez (22613), Ariela Mishaan (22052), Diego Soto (22737)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 2
 * 30-01-2023
 * Clase CalcTest: Pruebas Unitarias
 */


class CalcTest {

	Calculadora calculadora = new Calculadora();
	StackHandmade stack = new StackHandmade<Integer>();
	int numero = 4;

	@Test
	void pullpushTest() {
		StackHandmade stack = new StackHandmade<Integer>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		int resultado = 0;
		resultado = (int) stack.pull();
		assertEquals(2, resultado);
	}

	@Test
	void sumaTest() throws Exception{
		Calculadora calculadora = new Calculadora();
		ArrayList<String> lista =  new ArrayList<>();
		lista.add("2");
		lista.add("3");
		lista.add("+");
		int resultado = calculadora.Calculate(lista);
		assertEquals(5, resultado);
	}

	@Test
	void restaTest() throws Exception{
		Calculadora calculadora = new Calculadora();
		ArrayList<String> lista =  new ArrayList<>();
		lista.add("3");
		lista.add("2");
		lista.add("-");
		int resultado = calculadora.Calculate(lista);
		assertEquals(-1, resultado);
	}

	@Test
	void multiTest() throws Exception{
		Calculadora calculadora = new Calculadora();
		ArrayList<String> lista =  new ArrayList<>();
		lista.add("7");
		lista.add("9");
		lista.add("*");
		int resultado = calculadora.Calculate(lista);
		assertEquals(63, resultado);
	}

	@Test
	void diviTest() throws Exception{
		Calculadora calculadora = new Calculadora();
		ArrayList<String> lista =  new ArrayList<>();
		lista.add("6");
		lista.add("24");
		lista.add("/");
		int resultado = calculadora.Calculate(lista);
		assertEquals(4, resultado);
	}

	@Test
	void unmontonTest() throws Exception{
		Calculadora calculadora = new Calculadora();
		ArrayList<String> lista =  new ArrayList<>();
		lista.add("1");
		lista.add("2");
		lista.add("+");
		lista.add("4");
		lista.add("*");
		lista.add("3");
		lista.add("+");
		int resultado = calculadora.Calculate(lista);
		assertEquals(15, resultado);
	}
}