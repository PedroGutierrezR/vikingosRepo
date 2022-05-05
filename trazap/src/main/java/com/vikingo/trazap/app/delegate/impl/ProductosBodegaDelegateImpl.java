package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.ProductosBodegaDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.ProductosBodegaService;
import com.vikingo.trazap.app.service.request.ProductosBodegaRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("productosBodegaDelegate")
public class ProductosBodegaDelegateImpl implements ProductosBodegaDelegate {

	
	@Autowired
	private ProductosBodegaService productosBodegaService;
	
	@Override
	public ResponseServiceObject findAll() {
		return productosBodegaService.findAll();
	}

	@Override
	public ResponseServiceObject save(int idProductoBodega, ProductosBodegaRequest productosBodegaRequest) {
		return productosBodegaService.save(idProductoBodega, productosBodegaRequest);
	}
	
	@Override
	public ResponseServiceObject save(ProductosBodegaRequest productosBodegaRequest) {
		return productosBodegaService.save(productosBodegaRequest);
	}

	@Override
	public ResponseServiceObject findByid(Integer idProductoBodega) throws ServiceException {
		return productosBodegaService.findByid(idProductoBodega);
	}
}
