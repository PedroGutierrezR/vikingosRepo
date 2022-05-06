package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.ProveedorDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.repository.model.Proveedor;
import com.vikingo.trazap.app.service.ProveedorService;
import com.vikingo.trazap.app.service.request.ProveedorRequest;
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

	@Override
	public ResponseServiceObject save(int idProveedor, ProveedorRequest proveedorRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject findByid(Integer idProveedor) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(ProveedorRequest proveedorRequest) {
		// TODO Auto-generated method stub
		
		proveedorService.deleteById(proveedorRequest);
	}	
}
