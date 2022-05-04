package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.ProveedorDelegate;
import com.vikingo.trazap.app.repository.model.Proveedor;
import com.vikingo.trazap.app.service.ProveedorService;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("proveedorDelegate")
public class ProveedorDelegateImpl implements ProveedorDelegate{

	@Autowired
	private ProveedorService proveedorService;
	
	@Override
	public ResponseServiceObject findAll() {
		return proveedorService.findAll();
	}

	@Override
	public ResponseServiceObject save(Proveedor proveedor) {
		return proveedorService.save(proveedor);
	}	
}
