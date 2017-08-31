package com.calculadora.bussines;

import java.util.HashMap;

import com.calculadora.services.Command;

public class Operacion {

	HashMap<String, Command> op;

	public Operacion() {

		op = new HashMap<>();
		op.put("+", new Suma());
		op.put("-", new Resta());
		op.put("*", new Multiplicacion());
		op.put("/", new Division());
		op.put("^", new Potencia());
	}

	public Command buscarOperacion(String operador) {
		return op.get(operador);
	}

}
