package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.repository.model.Proveedores;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface ProveedoresService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Proveedores proveedores);
}
