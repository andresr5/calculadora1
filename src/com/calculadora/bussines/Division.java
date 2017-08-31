package com.calculadora.bussines;

import com.calculadora.services.Command;

public class Division implements Command {

	public Division() {

	}

	@Override
	public double ejecutar(double a, double b) {
		return a / b;
	}

}
