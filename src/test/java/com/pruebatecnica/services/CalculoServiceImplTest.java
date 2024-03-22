package com.pruebatecnica.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebatecnica.entity.DtoInput;

@ExtendWith(MockitoExtension.class)
class CalculoServiceImplTest {

	private DtoInput variables = new DtoInput();

	@InjectMocks
	CalculoServiceImpl underTest;

	@Test
	void testCalculaMod() throws Exception {
		variables.setX(7);
		variables.setY(5);
		variables.setN(12345);
		int actual = underTest.calculaMod(variables);
		assertThat(actual).isEqualTo(12339);
	}
	
	@Test
	void testValidaParametros() throws Exception {
		variables.setX(0);
		variables.setY(0);
		variables.setN(0);
		boolean actual = underTest.validaParametros(variables);
		assertThat(actual).isEqualTo(false);
	}
}