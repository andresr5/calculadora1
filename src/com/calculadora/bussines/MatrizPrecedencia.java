package com.calculadora.bussines;

public class MatrizPrecedencia {
	
	public int [][] matriz = new int [8][8];
	
	
	public void iniciaMatriz(){
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if(j<=i) matriz[i][j] = 1;
				else matriz[i][j] = 0;
			}
		}
		
	}
	
	public static void main(String[] args) {
		MatrizPrecedencia mP = new MatrizPrecedencia();
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
