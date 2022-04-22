package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.BodegaDelegate;
import com.vikingo.trazap.app.repository.model.Bodega;
import com.vikingo.trazap.app.service.BodegaService;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("bodegaDelegate")
public class BodegaDelegateImpl implements BodegaDelegate {
	
	@Autowired
	private BodegaService bodegaService;
	
	@Override
	public ResponseServiceObject findAll() {
		return bodegaService.findAll();
	}

	@Override
	public ResponseServiceObject save(Bodega bodega) {
		return bodegaService.save(bodega);
	}

}
