package com.calculadora.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.calculadora.bussines.Division;
import com.calculadora.bussines.Multiplicacion;
import com.calculadora.bussines.Operacion;
import com.calculadora.bussines.Resta;
import com.calculadora.bussines.Suma;
import com.calculadora.services.Command;
import com.calculadora.servicesImpl.Invoker;

public class OperacionController {

	static Operacion operacion;
	static Command command;

	public  boolean validarTamanioOperador(String texto) {
		Pattern p = Pattern.compile("[+-/*]");
		Matcher m = p.matcher(texto);
		if (!m.find()) {
			System.out.println("\"Debe ser una operacion de +   -    *  /\"");
			return false;
		}
		System.out.println(texto);

		return true;
	}

	public  double[] obtenerOperandos(String texto, String simbolo) {

		double[] a = new double[10];
		if (texto != null) {
			if (texto.split(simbolo).length > 0) {
				a[0] = Double.parseDouble(texto.split(simbolo)[0]);

			}
			if (texto.split(simbolo).length == 2) {
				a[1] = Double.parseDouble(texto.split(simbolo)[1]);

			}
		}
		return a;
	}
	
	/**
	 * Este metodo se encarga de realizar la operacion segun el signo que venga en la cadena de texto
	 * 
	 * */
	public  double operarSinPrecedencia(Invoker aInvoker, String ecuacion) {

		Command command;
		if(operacion==null)
			operacion = new Operacion();
		
			
			
			command = operacion.buscarOperacion("+");
			double[] arreglo = obtenerOperandos(ecuacion, "\\+");
		if(command!=null)
			return command.ejecutar(arreglo[0], arreglo[1]);
		

		if (ecuacion.indexOf("-") != -1) {
			
			operacion = new Operacion();
			command = new Resta(operacion);
			aInvoker.setCommand(command);
			return command.ejecutar(arreglo[0], arreglo[1]);

		}
		if (ecuacion.indexOf("*") != -1) {
			 arreglo = obtenerOperandos(ecuacion, "\\*");
			operacion = new Operacion();
			command = new Multiplicacion(operacion);
			aInvoker.setCommand(command);
			return command.ejecutar(arreglo[0], arreglo[1]);
		}
		if (ecuacion.indexOf("/") != -1) {
			 arreglo = obtenerOperandos(ecuacion, "\\/");
			operacion = new Operacion();
			command = new Division(operacion);
			aInvoker.setCommand(command);
			return command.ejecutar(arreglo[0], arreglo[1]);
		}

		return 0;
	}

}
