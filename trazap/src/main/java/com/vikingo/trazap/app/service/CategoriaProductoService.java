package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.model.request.CategoriaProductoRequest;
import com.vikingo.trazap.app.repository.model.CategoriaProducto;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface CategoriaProductoService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(int idCategoriaProducto, CategoriaProductoRequest categoriaProductoRequest);
	public ResponseServiceObject save(CategoriaProducto categoriaProducto);
	
}
