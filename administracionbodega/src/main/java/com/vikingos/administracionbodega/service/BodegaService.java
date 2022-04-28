package com.vikingos.administracionbodega.service;

import com.vikingos.administracionbodega.exception.ServiceException;
import com.vikingos.administracionbodega.request.BodegaRequest;
import com.vikingos.administracionbodega.service.response.ResponseServiceObject;

public interface BodegaService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest);
	public ResponseServiceObject save(BodegaRequest bodegaRequest);
	public ResponseServiceObject findByid(Integer idBodega) throws ServiceException;
	
	
}