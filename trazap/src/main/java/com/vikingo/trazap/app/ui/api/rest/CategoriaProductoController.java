package com.vikingo.trazap.app.ui.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikingo.trazap.app.delegate.CategoriaProductoDelegate;
import com.vikingo.trazap.app.repository.model.CategoriaProducto;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/categoriaProductos")
public class CategoriaProductoController {

	@Autowired
	private CategoriaProductoDelegate categoriaProductoDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getCategoriaProducto(){
		return new ResponseEntity<ResponseServiceObject>(categoriaProductoDelegate.findAll() ,HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createCategoriaProducto(@RequestBody CategoriaProducto categoriaProducto){
		return new ResponseEntity<ResponseServiceObject>(categoriaProductoDelegate.save(categoriaProducto), HttpStatus.OK);
	}
	
}
