package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.ProductoRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface ProductoService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(ProductoRequest productoRequest);
	public ResponseServiceObject save(int idProducto, ProductoRequest productoRequest);
	public ResponseServiceObject findByid(Integer idProducto) throws ServiceException;
	public void deleteById(ProductoRequest productoRequest);
	
}
