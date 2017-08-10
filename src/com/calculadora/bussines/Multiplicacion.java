package com.calculadora.bussines;

import com.calculadora.services.Command;

public class Multiplicacion implements Command{
	
	private Operacion operacion;
	
	public Multiplicacion(Operacion aOperacion) {
		this.operacion = aOperacion;
	}
	
	@Override
	public double ejecutar(double a, double b) {
		return operacion.multiplicar(a, b);
	}

	
}
