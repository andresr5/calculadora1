
package com.calculadora.cliente;

import java.util.Scanner;

import com.calculadora.controller.OperacionController;
import com.calculadora.servicesImpl.Invoker;

public class Cliente {

	public static void main(String[] args) {

		while (true) {
		
			System.out.println("\n Bienvenido a La calculadora.");
			System.out.println("Ingrese la operación a realizar: ");

			Scanner teclado = new Scanner(System.in);
			String lecturaTeclado = teclado.nextLine();
			Invoker calculadoraFisica = new Invoker();
			
			if(OperacionController.validarTamanioOperador(lecturaTeclado)) {
			double resultado = OperacionController.operarSinPrecedencia(calculadoraFisica, lecturaTeclado);
			
			System.out.println("El resultado es: " + resultado);
			}
			// calculadoraFisica.setCommand(sumar);

			/*
			 * if(lecturaTeclado.indexOf("+")!=-1){ Command suma = new Suma(null);
			 * suma.ejecutar(2.0, 3.5); }
			 */
		}

	}
}
