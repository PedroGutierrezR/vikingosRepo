package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.repository.model.ProductoProveedor;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface ProductoProveedorService {

	
	public ResponseServiceObject findAll();
	public ResponseServiceObject save(ProductoProveedor productoProveedor);
}
