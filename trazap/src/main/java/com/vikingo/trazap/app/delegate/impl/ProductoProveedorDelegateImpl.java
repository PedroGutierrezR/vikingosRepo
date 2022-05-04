package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.ProductoProveedorDelegate;
import com.vikingo.trazap.app.repository.model.ProductoProveedor;
import com.vikingo.trazap.app.service.ProductoProveedorService;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("productosProveedorDelegate")
public class ProductoProveedorDelegateImpl implements ProductoProveedorDelegate{

	@Autowired
	private ProductoProveedorService productoProveedorService;

	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return productoProveedorService.findAll();
	}

	@Override
	public ResponseServiceObject save(ProductoProveedor productoProveedor) {
		// TODO Auto-generated method stub
		return productoProveedorService.save(productoProveedor);
	}
	
	
}
