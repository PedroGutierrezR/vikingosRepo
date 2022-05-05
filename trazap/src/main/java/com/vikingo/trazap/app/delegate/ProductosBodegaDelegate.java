package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.ProductosBodegaRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface ProductosBodegaDelegate {

	public ResponseServiceObject findAll();
	//save crea y actualiza
	public ResponseServiceObject save(ProductosBodegaRequest productosBodegaRequest);
	public ResponseServiceObject save(int idProductosBodega, ProductosBodegaRequest productosBodegaRequest);
	public ResponseServiceObject findByid(Integer idProductosBodega) throws ServiceException;
}
