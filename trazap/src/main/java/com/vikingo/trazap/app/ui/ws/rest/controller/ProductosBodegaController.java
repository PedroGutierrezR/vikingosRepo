package com.vikingo.trazap.app.ui.ws.rest.controller;

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

import com.vikingo.trazap.app.delegate.ProductosBodegaDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.ProductosBodegaRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/productosBodegaDelegate")
public class ProductosBodegaController {

	@Autowired
	private ProductosBodegaDelegate productosBodegaDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getProductosBodega(){
		return new ResponseEntity<ResponseServiceObject>(productosBodegaDelegate.findAll(), HttpStatus.OK);
	}
	
	@PutMapping(path = "{idProductosBodega}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> updateProductosBodega(@PathVariable int idProductosBodega, @RequestBody ProductosBodegaRequest productosBodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(productosBodegaDelegate.save(idProductosBodega, productosBodegaRequest), HttpStatus.OK);
	} 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createProductosBodega(@RequestBody ProductosBodegaRequest productosBodegaRequest){
		return new ResponseEntity<ResponseServiceObject>(productosBodegaDelegate.save(productosBodegaRequest), HttpStatus.OK);
	}

	@GetMapping(path = "{idProductosBodega}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getProductosBodegas(@PathVariable Integer idProductosBodega) throws ServiceException {
		return new ResponseEntity<ResponseServiceObject>(productosBodegaDelegate.findByid(idProductosBodega), HttpStatus.OK);
	}
}
