package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.BodegaDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.BodegaService;
import com.vikingo.trazap.app.service.request.BodegaRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("bodegaDelegate")
public class BodegaDelegateImpl implements BodegaDelegate {
	
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
