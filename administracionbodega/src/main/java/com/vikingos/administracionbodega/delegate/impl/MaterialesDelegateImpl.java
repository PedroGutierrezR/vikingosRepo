package com.vikingos.administracionbodega.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingos.administracionbodega.delegate.MaterialesDelegate;
import com.vikingos.administracionbodega.exception.ServiceException;
import com.vikingos.administracionbodega.request.MaterialesRequest;
import com.vikingos.administracionbodega.service.MaterialesService;
import com.vikingos.administracionbodega.service.response.ResponseServiceObject;

@Component("materialesDelegate")
public class MaterialesDelegateImpl implements MaterialesDelegate {

	@Autowired
	private MaterialesService materialesService;
	
	@Override
	public ResponseServiceObject findAll() {
		return materialesService.findAll();
	}

	@Override
	public ResponseServiceObject save(int idProducto, MaterialesRequest materialesRequest) {
		return materialesService.save(idProducto, materialesRequest);
	}
	
	@Override
	public ResponseServiceObject save(MaterialesRequest materialesRequest) {
		return materialesService.save(materialesRequest);
	}

	@Override
	public ResponseServiceObject findByid(Integer idProducto) throws ServiceException {
		return materialesService.findByid(idProducto);
	}

	
}
