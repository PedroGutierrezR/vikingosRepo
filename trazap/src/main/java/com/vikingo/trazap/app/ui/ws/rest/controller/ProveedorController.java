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

import com.vikingo.trazap.app.delegate.ProveedorDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.repository.model.Proveedor;
import com.vikingo.trazap.app.service.request.ProveedorRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;



@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

		@Autowired
		private ProveedorDelegate proveedorDelegate;
		
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseServiceObject> getProveedor(){
			return new ResponseEntity<ResponseServiceObject>(proveedorDelegate.findAll() ,HttpStatus.OK);
		}
		
		@PutMapping(path = "{idProveedor}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseServiceObject> updateProveedor(@PathVariable int idProveedor, @RequestBody ProveedorRequest proveedorRequest){
			return new ResponseEntity<ResponseServiceObject>(proveedorDelegate.save(idProveedor, proveedorRequest), HttpStatus.OK);
		} 
		
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseServiceObject> createProveedor(@RequestBody Proveedor proveedor){
			return new ResponseEntity<ResponseServiceObject>(proveedorDelegate.save(proveedor), HttpStatus.OK);
		}

		@GetMapping(path = "{idProveedor}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseServiceObject> getProveedor(@PathVariable Integer idProveedor) throws ServiceException {
			return new ResponseEntity<ResponseServiceObject>(proveedorDelegate.findByid(idProveedor), HttpStatus.OK);
		}
		
		
		@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResponseServiceObject> deleteProveedor(@RequestBody ProveedorRequest proveedorRequest){
			return getProveedor();
		}
}
