package com.calculadora.bussines;

import java.util.HashMap;

import com.calculadora.services.Command;

public class Operacion {
	
	HashMap<String,Command> op;
	
	public Operacion() {
	
		op=new HashMap<>();
		op.put("+",new Suma());
	}
	
	public Command buscarOperacion(String operador) {
		return op.get(operador);
	}
	
	public double restar(double a, double b){		
		return a-b;
	}
	
	public double multiplicar(double a, double b){
		return a*b;
	}

	public double dividir(double a,double b) {
		return a/b;
	}
}
