package com.pruebatecnica.services;

import org.springframework.stereotype.Service;

import com.pruebatecnica.entity.DtoInput;

@Service
public class CalculoServiceImpl implements CalculoService {

	@Override
	public int calculaMod(DtoInput variables) throws ArithmeticException {
		int mayor = 0;
		try {
			if(!validaParametros(variables)) {//si la validacion retorna false la operacion retorna 0
				return -1;
			}
			
			int x = variables.getX();
			int y = variables.getY();
			int n = variables.getN();
			for (int k = 0; k <= n; k++) {
				if (k % x == y) {
					mayor = k;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mayor;
	}
	
	public boolean validaParametros(DtoInput variables) {
	boolean value=true;
		try {
			if(variables.getX()==0 && variables.getX()<=0 ) {//se valida que x no sea negativo y que sea mayor a cero para que la operacion no genere error aritmetico 
				value=false;
			}
			if(variables.getY()<0) {//Se valida que el valor de Y sea positivo
				value=false;
			}
			if(variables.getN()<0) {//Se valida que el valor de N sea positivo
				value=false;
			}
			if(variables.getX()==0 && variables.getY()==0 && variables.getN()==0) {//valida que al menos traiga un dato mayor a 0
				value=false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

}
