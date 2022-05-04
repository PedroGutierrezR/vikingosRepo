package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.repository.model.ProductoProveedor;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface ProductoProveedorDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(ProductoProveedor productoProveedor);

}