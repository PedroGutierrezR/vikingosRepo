package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.repository.model.CategoriaProducto;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface CategoriaProductoDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(CategoriaProducto categoriaProducto);
	
}
