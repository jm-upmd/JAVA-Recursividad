package recursividad;

import java.util.Scanner;

public class EjemplosRecursividad {

	static long cont = 0;

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		
		System.out.println("Numero entero positivo para calcular su factorial: ");
		int numero = teclado.nextInt(); System.out.println("Factorial: " +
		factorial(numero));
		
		
		System.out.println("Cuantos números quieres para la sucesión de Fibonacci: "
		); long fibNumero = teclado.nextLong();
		System.out.println("Serie de Fibonacci:\n"); sucesionFibonacci(fibNumero);
		
		//System.out.printf("Llamadas a fibonacci(): %,d\n" , cont);
		 
		
		System.out.println("Número sobre el que consultar si es primo: ");
		long priNumero = teclado.nextLong();
		System.out.println(esPrimo(priNumero, 2) ? "SI es primo" : "NO es primo");
		System.out.println("Contador: " + cont);
		cont=0;
		System.out.println(esPrimo2(priNumero, 2) ? "*SI es primo" : "*NO es primo");
		System.out.println("Contador: " + cont);

		teclado.close();

	}

	// Función recursiva que calcula el factorial de un número entero. 

	static long factorial(int n) {
		// System.out.println("** Lamada a función con n=" + n);
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	// Esta sería una versión no recursiva para el cálculo del factorial
	static long factorial2(int n) {

		long factorial = n;
		if (n == 0)
			return 1;

		for (long i = (n - 1); i > 1; i--) {
			factorial = factorial * i;
		}
		return factorial;
	}

	// Otra forma de metodo recursivo utilizando otras instrucciones y
	// chequeando que no se le da un método negativo.

	public static long factorial3(int n) {
		if (n < 0)
			throw new IllegalArgumentException("No puedo calcular el factoria de un número negativo");
		return (n < 2) ? 1 : n * factorial3(n - 1);
	}

	// Otro ejemplo de recursividad. Calculo de la serie de Fibonacci

	/*
	 * En matemáticas, la sucesión de Fibonacci es la siguiente sucesión infinita de
	 * números naturales:
	 * 
	 * 0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597...
	 * 
	 * La sucesión comienza con los números 0 y 1, y a partir de estos, <<cada
	 * término es la suma de los dos anteriores>>, esta es la relación de
	 * recurrencia que la define.
	 * 
	 * Los números de Fibonacci quedan definidos por la ecuación:
	 * 
	 * Los dos primeros números son 0,1. El calculo del tercer númros de la sucesión
	 * se obtine con la fórmula: f(n) = f(n − 1) + f( n − 2)
	 * 
	 * 
	 * https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci
	 * 
	 */

	static void sucesionFibonacci(long n) {

		for (int i = 0; i < n; i++) {
			System.out.println(fibonacci(i));
		}
	}

	public static long fibonacci(long n) {
		cont++;
		if (n < 0)
			throw new IllegalArgumentException("No se acepta número negativo");

		if (n < 2)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);

		// O escrito con otra sintaxis:
		// return (n < 2) ? n : fibonacci(n-1) + fibonacci(n-2);
	}

	
	private static boolean esPrimo(long num, long divisor) {
		cont++;
		if ( divisor >= num) {
			return true;
		} else {
			if (num % divisor == 0) {
				return false;
			} else {
				return esPrimo(num, divisor + 1);
			}
		}
	}
	
	private static boolean esPrimo2(long num, long divisor) {
		cont++;
		if ( divisor > num / 2) {
			return true;
		} else {
			if (num % divisor == 0) {
				return false;
			} else {
				return esPrimo2(num, divisor + 1);
			}
		}
	}
	
	

}
