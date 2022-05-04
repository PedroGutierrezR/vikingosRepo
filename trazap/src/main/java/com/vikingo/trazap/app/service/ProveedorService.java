package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.repository.model.Proveedor;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface ProveedorService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Proveedor proveedores);
}
