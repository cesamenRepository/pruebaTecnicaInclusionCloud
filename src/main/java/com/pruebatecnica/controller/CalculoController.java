package com.pruebatecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.entity.DtoInput;
import com.pruebatecnica.services.CalculoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
public class CalculoController {
	@Autowired
	private CalculoService service;

	@Operation(description = "Metodo para traer operacion get")
	@GetMapping("/get-consulta/valorx/{x}/valory/{y}/valorn/{n}")
	public ResponseEntity<?> consultaGet(@Valid @PathVariable int x, @Valid @PathVariable int y,
			@Valid @PathVariable int n) {
		DtoInput inputs = new DtoInput();
		int result = 0;
		try {
			inputs.setX(x);
			inputs.setY(y);
			inputs.setN(n);
			result = service.calculaMod(inputs);
			if (result == -1) {// si la respuesta del servicio es -1 significa que no paso la validacion de los
				// parametros de entrada
				return ResponseEntity.status(HttpStatus.OK).body("Verifique los parametros de entrada del body");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body("Verifique los parametros de entrada");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@Operation(description = "Metodo para traer operacion post")
	@PostMapping("/post-consulta")
	public ResponseEntity<?> consultaPost(@Valid @RequestBody DtoInput inputs) {
		int result = 0;
		result = service.calculaMod(inputs);
		if (result == -1) {// si la respuesta del servicio es -1 significa que no paso la validacion de los
							// parametros de entrada
			return ResponseEntity.status(HttpStatus.OK).body("Verifique los parametros de entrada del body");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

}
