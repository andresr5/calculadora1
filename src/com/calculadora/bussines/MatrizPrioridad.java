package com.calculadora.bussines;

public class MatrizPrioridad {

	public int[][] matriz = new int[7][7];
	
	public void matrizPrioridad(){
		iniciaMatriz();
	}

	public void iniciaMatriz() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j <= i)
					matriz[i][j] = 1;
				else
					matriz[i][j] = 0;
			}

		}
		matriz[0][1] = matriz[2][3] = 1;

		for (int k = 0; k < 7; k++) {
			matriz[5][k] = 0;
			matriz[k][5] = 0;
			matriz[k][6] = 1;
		}

		matriz[5][6] = 0;

	}
	
	
	public int prioridad(char op1, char op2){
		
		
		//System.out.println(op1+" -- "+op2);
		int i = 0,j= 0;
		switch (op1) {
		case '+': i = 0; break;
		case '-': i = 1; break;
		case '*': i = 2; break;
		case '/': i = 3; break;
		case '^': i = 4; break;
		case '(': i = 5; break;
		
		}
		
		switch (op2) {
		case '+': j = 0; break;
		case '-': j = 1; break;
		case '*': j = 2; break;
		case '/': j = 3; break;
		case '^': j = 4; break;
		case '(': j = 5; break;
		case ')': j = 6; break;
		}
		return (matriz[i][j]);
	}

	public static void main(String[] args) {
		MatrizPrioridad mP = new MatrizPrioridad();
		mP.iniciaMatriz();
		mP.matriz[0][1] = mP.matriz[2][3] = 1;
		for (int i = 0; i < mP.matriz.length; i++) {
			for (int j = 0; j < mP.matriz.length; j++) {
				System.out.print(mP.matriz[i][j]);
			}
			System.out.println("");
		}

	}
}
