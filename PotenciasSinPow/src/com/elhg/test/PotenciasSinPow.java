package com.elhg.test;

import java.util.ArrayList;
import java.util.List;

public class PotenciasSinPow {

	public static void main(String[] args) {
		System.out.println("pow(2,0) = "+new PotenciasSinPow().potencias(2,0));
		System.out.println("pow(3,4) = "+new PotenciasSinPow().potencias(3,4));
		System.out.println("pow(4,3) = "+new PotenciasSinPow().potencias(4,3));
		System.out.println("pow(6,2) = "+new PotenciasSinPow().potencias(6,2));
		System.out.println("pow(10,4) = "+new PotenciasSinPow().potencias(10,4));
		
	}
	

	public int multiplicacionConSumas(int numero1, int numero2) {
		int acumulado = 0;
		for(int i=1; i<=numero2; i++) {
			acumulado = acumulado + numero1;
		}
		return acumulado;
	}
	
	public long potencias(int base, int exponente) {
		List<Integer> listElementos= new ArrayList<Integer>();
		
		if(exponente==0) {
			return 1;
		}
		
		for(int i=0; i<exponente; i++) {
			listElementos.add(base);
		}
		
		while(listElementos.size() >= 2) {
			int ultimo = listElementos.get(listElementos.size()-1);
			int penultimo = listElementos.get(listElementos.size()-2);
						
			int auxiliar = multiplicacionConSumas(penultimo, ultimo);
			
			if(listElementos.size() > 2 ) {
				listElementos.remove(listElementos.size()-1);
				listElementos.remove(listElementos.size()-2);
			}else {
				listElementos.remove(1);
				listElementos.remove(0);				
			}
		
			listElementos.add(auxiliar);
		}
		
		return listElementos.get(0);		
	}

}
