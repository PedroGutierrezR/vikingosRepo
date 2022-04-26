package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.model.request.EstadoTrazabilidadRequest;
import com.vikingo.trazap.app.repository.model.EstadoTrazabilidad;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface EstadoTrazabilidadService {
	
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(int idBodega, EstadoTrazabilidadRequest estadoTrazabilidadRequest);
	public ResponseServiceObject save(EstadoTrazabilidad estadoTrazabilidad);
	
}
