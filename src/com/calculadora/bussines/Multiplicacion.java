package com.calculadora.bussines;

import com.calculadora.services.Command;

public class Multiplicacion implements Command {

	public Multiplicacion() {

	}

	@Override
	public double ejecutar(double a, double b) {
		return a * b;
	}

}
