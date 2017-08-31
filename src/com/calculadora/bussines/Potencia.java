package com.calculadora.bussines;

import com.calculadora.services.Command;

public class Potencia implements Command {

	public Potencia() {

	}

	@Override
	public double ejecutar(double a, double b) {
		return Math.pow(a, b);
	}

}
