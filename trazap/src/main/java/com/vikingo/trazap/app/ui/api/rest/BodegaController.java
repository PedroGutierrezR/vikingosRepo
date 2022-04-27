package com.vikingo.trazap.app.ui.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vikingo.trazap.app.delegate.BodegaDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.model.request.BodegaRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

	@Autowired
	private BodegaDelegate bodegaDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getBodegas(){
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.findAll(), HttpStatus.OK);
	}
	
	@PutMapping(path = "{idBodega}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> updateBodega(@PathVariable int idBodega, @RequestBody BodegaRequest bodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.save(idBodega, bodegaRequest), HttpStatus.OK);
	} 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createBodega(@RequestBody BodegaRequest bodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.save(bodegaRequest), HttpStatus.OK);
	}

	@GetMapping(path = "{idBodega}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getBodegas(@PathVariable Integer idBodega) throws ServiceException {
		return new ResponseEntity<ResponseServiceObject>(bodegaDelegate.findByid(idBodega), HttpStatus.OK);
	}

}
