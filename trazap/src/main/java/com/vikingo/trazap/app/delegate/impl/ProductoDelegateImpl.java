package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.ProductoDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.ProductoService;
import com.vikingo.trazap.app.service.request.ProductoRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("productoDelegate")
public class ProductoDelegateImpl implements ProductoDelegate {

	@Autowired
	private ProductoService productoService;
	
	@Override
	public ResponseServiceObject findAll() {
		return productoService.findAll();
	}

	@Override
	public ResponseServiceObject save(ProductoRequest productoRequest) {
		return productoService.save(productoRequest);
	}

	@Override
	public ResponseServiceObject save(int idProducto, ProductoRequest productoRequest) {
		return productoService.save(idProducto,productoRequest);
	}

	@Override
	public ResponseServiceObject findByid(Integer idProducto) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject deleteById(ProductoRequest productoRequest) {
		return productoService.deleteById(productoRequest);
	}

}
