package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.repository.model.Bodega;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface BodegaDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Bodega bodega);
	
}
