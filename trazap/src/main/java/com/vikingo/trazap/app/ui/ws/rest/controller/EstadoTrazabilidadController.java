package com.vikingo.trazap.app.ui.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikingo.trazap.app.delegate.EstadoTrazabilidadDelegate;
import com.vikingo.trazap.app.repository.model.EstadoTrazabilidad;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/estadoTrazabilidad")
public class EstadoTrazabilidadController {

	@Autowired
	private EstadoTrazabilidadDelegate estadoTrazabilidadDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getEstadoTrazabilidad(){
		return new ResponseEntity<ResponseServiceObject>(estadoTrazabilidadDelegate.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createCategoriaProducto(@RequestBody EstadoTrazabilidad estadoTrazabilidad){
		return new ResponseEntity<ResponseServiceObject>(estadoTrazabilidadDelegate.save(estadoTrazabilidad), HttpStatus.OK);
	}
	
}
