package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.repository.model.EstadoTrazabilidad;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface EstadoTrazabilidadDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(EstadoTrazabilidad estadoTrazabilidad);
	
}
