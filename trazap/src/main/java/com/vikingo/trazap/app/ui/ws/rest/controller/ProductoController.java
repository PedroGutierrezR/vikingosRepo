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

import com.vikingo.trazap.app.delegate.ProductoDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.ProductoRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoDelegate productoDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getProductos(){
		return new ResponseEntity<ResponseServiceObject>(productoDelegate.findAll(), HttpStatus.OK);
	}
	
	@PutMapping(path = "{idProducto}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> updateProducto(@PathVariable int idProducto, @RequestBody ProductoRequest productoRequest){
		return new ResponseEntity<ResponseServiceObject>(productoDelegate.save(idProducto, productoRequest), HttpStatus.OK);
	} 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createProducto(@RequestBody ProductoRequest productoRequest){
		return new ResponseEntity<ResponseServiceObject>(productoDelegate.save(productoRequest), HttpStatus.OK);
	}

	@GetMapping(path = "{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getProducto(@PathVariable Integer idProducto) throws ServiceException {
		return new ResponseEntity<ResponseServiceObject>(productoDelegate.findByid(idProducto), HttpStatus.OK);
	}
	
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> deleteProducto(@RequestBody ProductoRequest productoRequest){
		return getProductos();
	}
	
}
