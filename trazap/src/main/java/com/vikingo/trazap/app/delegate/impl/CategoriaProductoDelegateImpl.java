package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.CategoriaProductoDelegate;
import com.vikingo.trazap.app.repository.model.CategoriaProducto;
import com.vikingo.trazap.app.service.CategoriaProductoService;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("categoriaProductoDelegate")
public class CategoriaProductoDelegateImpl implements CategoriaProductoDelegate {

	@Autowired
	private CategoriaProductoService categoriaProductoService;
	
	@Override
	public ResponseServiceObject findAll() {
		return categoriaProductoService.findAll();
	}

	@Override
	public ResponseServiceObject save(CategoriaProducto categoriaProducto) {
		return categoriaProductoService.save(categoriaProducto);
	}

}
