package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.ProductosBodegaRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface ProductosBodegaService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(int idProductoBodega, ProductosBodegaRequest productosBodegaRequest);
	public ResponseServiceObject save(ProductosBodegaRequest productosBodegaRequest);
	public ResponseServiceObject findByid(Integer idProductoBodega) throws ServiceException;
	
}
