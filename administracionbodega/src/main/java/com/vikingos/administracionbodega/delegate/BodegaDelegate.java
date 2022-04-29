package com.vikingos.administracionbodega.delegate;

import com.vikingos.administracionbodega.exception.ServiceException;
import com.vikingos.administracionbodega.request.BodegaRequest;
import com.vikingos.administracionbodega.service.response.ResponseServiceObject;

public interface BodegaDelegate {

	public ResponseServiceObject findAll();
	//save crea y actualiza
	public ResponseServiceObject save(BodegaRequest bodegaRequest);
	public ResponseServiceObject save(int idBodega, BodegaRequest bodegaRequest);
	public ResponseServiceObject findByid(Integer idBodega) throws ServiceException;
	public void deleteById(BodegaRequest bodegaRequest);
	
}
