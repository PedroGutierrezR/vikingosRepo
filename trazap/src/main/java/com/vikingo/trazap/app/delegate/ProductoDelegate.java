package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.ProductoRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface ProductoDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(ProductoRequest productoRequest);
	public ResponseServiceObject save(int idProducto, ProductoRequest productoRequest);
	public ResponseServiceObject findByid(Integer idProducto) throws ServiceException;
	public ResponseServiceObject deleteById(ProductoRequest productoRequest);
	
}
