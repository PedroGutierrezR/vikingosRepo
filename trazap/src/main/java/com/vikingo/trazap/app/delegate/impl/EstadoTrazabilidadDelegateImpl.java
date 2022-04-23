package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.EstadoTrazabilidadDelegate;
import com.vikingo.trazap.app.repository.model.EstadoTrazabilidad;
import com.vikingo.trazap.app.service.EstadoTrazabilidadService;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("estadoTrazabilidadDelegate")
public class EstadoTrazabilidadDelegateImpl implements EstadoTrazabilidadDelegate {

	@Autowired
	private EstadoTrazabilidadService estadoTrazabilidadService;
	
	@Override
	public ResponseServiceObject findAll() {
		return estadoTrazabilidadService.findAll();
	}

	@Override
	public ResponseServiceObject save(EstadoTrazabilidad estadoTrazabilidad) {
		return estadoTrazabilidadService.save(estadoTrazabilidad);
	}

}
