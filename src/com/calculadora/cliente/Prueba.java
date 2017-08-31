package com.calculadora.cliente;

import java.util.Scanner;
import java.util.Stack;

import com.calculadora.bussines.MatrizPrioridad;
import com.calculadora.controller.OperacionController;

public class Prueba {

	private Stack signos;
	private Stack numeros;
	private MatrizPrioridad mP;

	void prueba() {

	}

	public void leerCadena(String cadenaTexto) {
		signos = new Stack<Character>();
		numeros = new Stack<Integer>();
		mP = new MatrizPrioridad();
		mP.iniciaMatriz();
		Prueba p1 = new Prueba();
		char[] arregloCadena = cadenaTexto.toCharArray();
		for (int i = 0; i < cadenaTexto.length(); i++) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("ITERATION----->> " + i);
			if (p1.esOperando(arregloCadena[i])) {
				String parse = String.valueOf(arregloCadena[i]);
				int valor = Integer.valueOf(parse);
				System.out.println("VALOR  " + valor);
				numeros.push(valor);
				System.out.println("No es operador  " + arregloCadena[i]);
				System.out.println(numeros);
			} else {
				if (signos.size() == 0) {
					signos.push(arregloCadena[i]);
					System.out.println("agrego por primera vez a signos:" + arregloCadena[i]);
				} else {
					char a = (char) signos.peek();
					if (mP.prioridad(a, arregloCadena[i]) == 0) {
						System.out.println("No tiene prioridad " + " signos peek " + a + " ante " + arregloCadena[i]);
						System.out.println(" signos antes de agregar " + signos);
						System.out.println(numeros);
						int contadormenosuno = i;
						contadormenosuno--;

						signos.push(arregloCadena[i]);
						System.out.println(" pila signos despues de agregar " + signos);
						System.out.println("pila numeros " + numeros);

					} else {
						System.out.println(
								"Entro cpm prioridad " + i + " para el signo " + a + " ante " + arregloCadena[i]);
						for (int j = 0; j < signos.size(); j++) {
							System.out.println("tamaño 1 " + signos);
							String signoPrioritario;
							if (!numeros.isEmpty() && numeros.size() >= 2) {

								System.out.println("tamaño 2 " + signos);
								System.out.println("pila numero " + numeros);
								int op1 = (int) numeros.pop();
								int op2 = (int) numeros.pop();

								OperacionController oC = new OperacionController();
								signoPrioritario = String.valueOf(signos.peek());
								System.out.println("{^^^^^operacion a realizar op2: " + op2 + " " + signoPrioritario
										+ " op2 " + op1);
								if (!signoPrioritario.equals("(")) {
									signos.pop();
									Double resultado = oC.operarSegunSigno(op2, op1, signoPrioritario);

									int intresultado = resultado.intValue();
									String parse = String.valueOf(resultado);
									Integer resultadoInt = intresultado;
									System.out.println("Resultado numero: " + resultadoInt);
									int contadormenosuno = j;
									if (contadormenosuno > 0)
										contadormenosuno--;

									if (arregloCadena[contadormenosuno] == ')') {
										if ((char) signos.peek() == '(') {
											signos.pop();
										}
									}
									numeros.push(resultadoInt);
								}

							}
							// int numeroAOperar = (int) numeros.pop();

						}

						signos.push(arregloCadena[i]);

						System.out.println("NUMEROS FINAL --->" + numeros);
						System.out.println("SIGNOS FINAL ---->" + signos);
					}
				}
			}

		}
		System.out.println(numeros.size());
		System.out.println(signos.size());
	}

	public boolean esOperando(char c) {
		return (c != '+' && c != '-' && c != '*' && c != '/' && c != '^' && c != ')' && c != '(');
	}

	public static void main(String[] args) {

		while (true) {

			Prueba p = new Prueba();
			System.out.println("Ingrese un numero. ");
			Scanner teclado = new Scanner(System.in);
			String cadenaTexto = teclado.nextLine();
			p.leerCadena(cadenaTexto);

		}
	}

}
