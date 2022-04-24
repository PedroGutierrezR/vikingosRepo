package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.TipoProductoDelegate;
import com.vikingo.trazap.app.repository.model.TipoProducto;
import com.vikingo.trazap.app.service.TipoProductoService;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("tipoProductoDelegate")
public class TipoProductoDelegateImpl implements TipoProductoDelegate{

	
	@Autowired
	private TipoProductoService tipoProductoService;
	
	@Override
	public ResponseServiceObject findAll() {
		return tipoProductoService.findAll();
	}

	@Override
	public ResponseServiceObject save(TipoProducto tipoProducto) {
		return tipoProductoService.save(tipoProducto);
	}
}
