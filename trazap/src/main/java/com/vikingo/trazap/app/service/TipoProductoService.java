package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.repository.model.TipoProducto;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface TipoProductoService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(TipoProducto tipoProducto);
}
