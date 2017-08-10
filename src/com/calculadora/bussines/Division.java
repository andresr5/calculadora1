package com.calculadora.bussines;

import com.calculadora.services.Command;

public class Division implements Command{

	public Operacion operacion;
	
	public Division(Operacion aOperacion){
		this.operacion = aOperacion;
	}
	
	@Override
	public double ejecutar(double a, double b) {
		return a/b;
	}



}
