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

import com.vikingo.trazap.app.delegate.ProveedorDelegate;
import com.vikingo.trazap.app.repository.model.Proveedor;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;



@RestController
@RequestMapping("/proveedores")
public class ProveedorController {


		@Autowired
		private ProveedorDelegate proveedoresDelegate;
		
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseServiceObject> getProveedores(){
			return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.findAll() ,HttpStatus.OK);
		}
		
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseServiceObject> createProveedores(@RequestBody Proveedor proveedores){
			return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.save(proveedores), HttpStatus.OK);
		}
}
