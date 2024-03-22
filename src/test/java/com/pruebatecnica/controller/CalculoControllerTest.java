package com.pruebatecnica.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnica.entity.DtoInput;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
 class CalculoControllerTest{

	@Autowired
	private MockMvc mockMvc;
	
//	@Test
	 void testConsultaPost() throws Exception {
		DtoInput inputs= new DtoInput();
		inputs.setN(1);
		inputs.setX(2);
		inputs.setY(3);
		MvcResult mockResult =  mockMvc.perform(MockMvcRequestBuilders.post("/post-consulta")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
				.content(mapToJson(inputs)))
				.andReturn();
		System.out.println("codigo response: " + mockResult);
	assertEquals(200, mockResult.getResponse().getStatus());
	} 
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.writeValueAsString(object);		
	}
}