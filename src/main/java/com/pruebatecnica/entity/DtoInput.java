package com.pruebatecnica.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoInput {
	@NotNull
	@NotEmpty
	private int x;
	
	@NotNull
	@NotEmpty
	private int y;
	
	@NotNull
	@NotEmpty
	private int n;
}
