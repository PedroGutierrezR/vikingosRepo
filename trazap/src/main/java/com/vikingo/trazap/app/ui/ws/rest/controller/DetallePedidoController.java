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

import com.vikingo.trazap.app.delegate.DetallePedidoDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.DetallePedidoRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/detallePedido")
public class DetallePedidoController {

	
	@Autowired
	private DetallePedidoDelegate detallePedidoDelegate;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getDetallePedido(){
		return new ResponseEntity<ResponseServiceObject>(detallePedidoDelegate.findAll(), HttpStatus.OK);
	}
	
	@PutMapping(path = "{idDetallePedido}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> updateDetallePedido(@PathVariable int idDetallePedido, @RequestBody DetallePedidoRequest detallePedidoRequest){
		return new ResponseEntity<ResponseServiceObject>(detallePedidoDelegate.save(idDetallePedido, detallePedidoRequest), HttpStatus.OK);
	} 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> createDetallePedido(@RequestBody DetallePedidoRequest detallePedidoRequest){
		return new ResponseEntity<ResponseServiceObject>(detallePedidoDelegate.save(detallePedidoRequest), HttpStatus.OK);
	}

	@GetMapping(path = "{idDetallePedido}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseServiceObject> getDetallePedido(@PathVariable Integer idDetallePedido) throws ServiceException {
		return new ResponseEntity<ResponseServiceObject>(detallePedidoDelegate.findByid(idDetallePedido), HttpStatus.OK);
	}
}
