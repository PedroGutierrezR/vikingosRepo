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

import com.vikingo.trazap.app.delegate.TrazabilidadDelegate;
import com.vikingo.trazap.app.repository.model.Trazabilidad;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/trazabilidad")
public class TrazabilidadController {

	@Autowired
	private TrazabilidadDelegate trazabilidadDelegate;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getTrazabilidad() {
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.findAll(), HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createTrazabilidad(@RequestBody Trazabilidad trazabilidad) {
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.save(trazabilidad), HttpStatus.OK);
	}
}
