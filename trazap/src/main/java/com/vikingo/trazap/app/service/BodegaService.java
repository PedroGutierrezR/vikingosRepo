package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.BodegaRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface BodegaService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest);
	public ResponseServiceObject save(BodegaRequest bodegaRequest);
	public ResponseServiceObject findByid(Integer idBodega) throws ServiceException;
	
}
