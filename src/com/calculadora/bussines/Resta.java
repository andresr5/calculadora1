package com.calculadora.bussines;

import com.calculadora.services.Command;

public class Resta implements Command{
	
	
	public Resta(){
		
	}
	
	@Override
	public double ejecutar(double a, double b) {
		return a - b;
		
	}

	

}
