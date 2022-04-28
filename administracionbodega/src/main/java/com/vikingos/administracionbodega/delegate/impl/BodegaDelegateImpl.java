package com.vikingos.administracionbodega.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingos.administracionbodega.delegate.BodegaDelegate;
import com.vikingos.administracionbodega.exception.ServiceException;
import com.vikingos.administracionbodega.request.BodegaRequest;
import com.vikingos.administracionbodega.service.BodegaService;
import com.vikingos.administracionbodega.service.response.ResponseServiceObject;

@Component("bodegaDelegate")
 class BodegaDelegateImpl implements BodegaDelegate {

	@Autowired
	private BodegaService bodegaService;
	
	@Override
	public ResponseServiceObject findAll() {
		return bodegaService.findAll();
	}

	@Override
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest) {
		return bodegaService.save(idBodega, bodegaRequest);
	}
	
	@Override
	public ResponseServiceObject save(BodegaRequest bodegaRequest) {
		return bodegaService.save(bodegaRequest);
	}

	@Override
	public ResponseServiceObject findByid(Integer idBodega) throws ServiceException {
		return bodegaService.findByid(idBodega);
	}

}
