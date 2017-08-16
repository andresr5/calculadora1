package com.calculadora.bussines;

import com.calculadora.services.Command;

public class Suma implements Command{
	
	
	
	public Suma(){
	 
	}
	
	@Override
	public double ejecutar(double a, double b) {
		 return a+b;		
	}

	

}
