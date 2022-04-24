package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.repository.model.TipoProducto;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface TipoProductoDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(TipoProducto tipoProducto);
}
