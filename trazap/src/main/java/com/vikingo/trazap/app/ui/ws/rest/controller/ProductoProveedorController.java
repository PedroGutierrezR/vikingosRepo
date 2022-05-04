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

import com.vikingo.trazap.app.delegate.ProductoProveedorDelegate;
import com.vikingo.trazap.app.repository.model.ProductoProveedor;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/productoProveedor")
public class ProductoProveedorController {

	
	@Autowired
	private ProductoProveedorDelegate productoProveedorDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getProductoProveedor(){
		return new ResponseEntity<ResponseServiceObject>(productoProveedorDelegate.findAll() ,HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createProductoProveedor(@RequestBody ProductoProveedor productoProveedor){
		return new ResponseEntity<ResponseServiceObject>(productoProveedorDelegate.save(productoProveedor), HttpStatus.OK);
	}
}
