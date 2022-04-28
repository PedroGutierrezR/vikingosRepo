package com.vikingos.administracionbodega.controller;

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

import com.vikingos.administracionbodega.delegate.MaterialesDelegate;
import com.vikingos.administracionbodega.exception.ServiceException;
import com.vikingos.administracionbodega.request.MaterialesRequest;
import com.vikingos.administracionbodega.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/materiales")
public class MaterialesController {

	@Autowired
	private MaterialesDelegate materialesDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getMateriales(){
		return new ResponseEntity<ResponseServiceObject>(materialesDelegate.findAll(), HttpStatus.OK);
	}
	
	@PutMapping(path = "{idProducto}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> updateMateriales(@PathVariable int idProducto, @RequestBody MaterialesRequest materialesRequest){
		return new ResponseEntity<ResponseServiceObject>(materialesDelegate.save(idProducto, materialesRequest), HttpStatus.OK);
	} 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createMateriales(@RequestBody MaterialesRequest materialesRequest){
		return new ResponseEntity<ResponseServiceObject>(materialesDelegate.save(materialesRequest), HttpStatus.OK);
	}

	@GetMapping(path = "{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getMateriales(@PathVariable Integer idProducto) throws ServiceException {
		return new ResponseEntity<ResponseServiceObject>(materialesDelegate.findByid(idProducto), HttpStatus.OK);
	}
	
}
