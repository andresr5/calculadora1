package com.calculadora.bussines;

import com.calculadora.services.Command;

public class Suma implements Command{
	
	private Operacion operacion;
	
	public Suma(Operacion aOperacion){
		this.operacion = aOperacion; 
	}
	
	@Override
	public double ejecutar(double a, double b) {
		return operacion.sumar(a, b);		
	}

	

}
