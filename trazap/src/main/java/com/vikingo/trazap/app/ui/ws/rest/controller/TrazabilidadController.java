package com.vikingo.trazap.app.ui.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikingo.trazap.app.delegate.TrazabilidadDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
//import com.vikingo.trazap.app.repository.model.Trazabilidad;
import com.vikingo.trazap.app.service.request.TrazabilidadRequest;
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
	@PutMapping(path = "{idTrazabilidad}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> updateTrazabilidad(@PathVariable int idTrazabilidad, @RequestBody TrazabilidadRequest trazabilidadRequest){
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.save(idTrazabilidad, trazabilidadRequest), HttpStatus.OK);
	} 

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createTrazabilidad(@RequestBody TrazabilidadRequest trazabilidadRequest) {
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.save(trazabilidadRequest), HttpStatus.OK);
		
	}
	
	@GetMapping(path = "{idTrazabilidad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getTrazabilidad(@PathVariable Integer idTrazabilidad) throws ServiceException {
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.findByid(idTrazabilidad), HttpStatus.OK);
	}
	
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> deleteTrazabilidad(@RequestBody TrazabilidadRequest trazabilidadRequest){
		return new ResponseEntity<ResponseServiceObject>(trazabilidadDelegate.deleteById(trazabilidadRequest), HttpStatus.OK);
	}
}
