package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.repository.model.Trazabilidad;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface TrazabilidadService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Trazabilidad trazabilidad);
	
}
