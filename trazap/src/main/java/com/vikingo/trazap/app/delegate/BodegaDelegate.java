package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.BodegaRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface BodegaDelegate {

	public ResponseServiceObject findAll();
	//save crea y actualiza
	public ResponseServiceObject save(BodegaRequest bodegaRequest);
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest);
	public ResponseServiceObject findByid(Integer idBodega) throws ServiceException;
	
}
