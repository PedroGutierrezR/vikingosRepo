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

import com.vikingo.trazap.app.delegate.PedidosDelegate;
import com.vikingo.trazap.app.repository.model.Pedidos;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {


	@Autowired
	private PedidosDelegate pedidosDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getPedidos(){
		return new ResponseEntity<ResponseServiceObject>(pedidosDelegate.findAll() ,HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createPedidos(@RequestBody Pedidos pedidos){
		return new ResponseEntity<ResponseServiceObject>(pedidosDelegate.save(pedidos), HttpStatus.OK);
	}
}
