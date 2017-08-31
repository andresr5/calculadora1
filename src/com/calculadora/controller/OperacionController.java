package com.calculadora.controller;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.calculadora.bussines.MatrizPrioridad;
import com.calculadora.bussines.Multiplicacion;
import com.calculadora.bussines.Operacion;
import com.calculadora.bussines.Resta;
import com.calculadora.services.Command;
import com.calculadora.servicesImpl.Invoker;

public class OperacionController {

	static Operacion operacion;
	static Command command;
	MatrizPrioridad mP = new MatrizPrioridad();

	public boolean esOperando(char c) {
		return (c != '+' && c != '-' && c != '*' && c != '/' && c != '^' && c != ')' && c != '(');
	}

	/*
	 * public void infijoAPosFijo(char[] infijo) { char[] postfijo = null; char
	 * elemento; Stack pila;
	 * 
	 * int i = 0; int j = -1; pila = new Stack<Character>(); while (i <
	 * infijo.length) { if (esOperando(infijo[i])) { postfijo[j++] = infijo[i++]; }
	 * else { while (!pila.isEmpty() && mP.prioridad((char) pila.peek(), infijo[i])
	 * == 1) { elemento = (char) pila.peek(); postfijo[++j] = elemento; } }
	 * if(infijo[i]==')') { elemento = pila. } } }
	 */

	public boolean validarTamanioOperador(String texto) {
		Pattern p = Pattern.compile("[+-/*]");
		Matcher m = p.matcher(texto);
		if (!m.find()) {
			System.out.println("\"Debe ser una operacion de +   -    *  /\"");
			return false;
		}
		System.out.println(texto);

		return true;
	}

	public double[] obtenerOperandos(String texto, String simbolo) {

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
	
	public double operarSegunSigno( int op1, int op2, String signo){
		Invoker pInvoker = new Invoker();
		Command command;
		if(operacion ==null)
		operacion = new Operacion();
		
		command = operacion.buscarOperacion(signo);
		return command.ejecutar(op1,op2);
	}
	
	
	
	/**
	 * Este metodo se encarga de realizar la operacion segun el signo que venga en
	 * la cadena de texto
	 * 
	 */

	public double operarSinPrecedencia(Invoker aInvoker, String ecuacion) {

		Command command;
		if (operacion == null)
			operacion = new Operacion();

		command = operacion.buscarOperacion("+");
		double[] arreglo = obtenerOperandos(ecuacion, "\\+");
		if (command != null)
			return command.ejecutar(arreglo[0], arreglo[1]);

		if (ecuacion.indexOf("-") != -1) {

			operacion = new Operacion();
			//command = new Resta(operacion);
			aInvoker.setCommand(command);
			return command.ejecutar(arreglo[0], arreglo[1]);

		}
		if (ecuacion.indexOf("*") != -1) {
			arreglo = obtenerOperandos(ecuacion, "\\*");
			operacion = new Operacion();
			//command = new Multiplicacion(operacion);
			aInvoker.setCommand(command);
			return command.ejecutar(arreglo[0], arreglo[1]);
		}
		if (ecuacion.indexOf("/") != -1) {
			arreglo = obtenerOperandos(ecuacion, "\\/");
			operacion = new Operacion();
			//command = new Division(operacion);
			aInvoker.setCommand(command);
			return command.ejecutar(arreglo[0], arreglo[1]);
		}

		return 0;
	}

}
