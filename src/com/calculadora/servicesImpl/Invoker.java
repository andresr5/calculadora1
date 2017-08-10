package com.calculadora.servicesImpl;

import com.calculadora.services.Command;

public class Invoker {
	
	private Command command;
	
	public void setCommand(Command aCommand){
		this.command = aCommand;
	}
	
	public void realizarOperacion(double a, double b){
		command.ejecutar(a, b);
	}
	
	
}
