package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.repository.model.Bodega;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface BodegaService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Bodega bodega);

}
