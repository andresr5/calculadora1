package com.calculadora.bussines;

import com.calculadora.services.Command;

public class Resta implements Command{
	
	private Operacion operacion;
	
	public Resta(Operacion aOperacion){
		this.operacion = aOperacion;
	}
	
	@Override
	public double ejecutar(double a, double b) {
		return operacion.restar(a, b);
		
	}

	

}
