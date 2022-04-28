package com.vikingos.administracionbodega.service;

import com.vikingos.administracionbodega.exception.ServiceException;
import com.vikingos.administracionbodega.request.MaterialesRequest;
import com.vikingos.administracionbodega.service.response.ResponseServiceObject;

public interface MaterialesService {


	public ResponseServiceObject findAll();
	public ResponseServiceObject save(int idProducto, MaterialesRequest materialesRequest);
	public ResponseServiceObject save(MaterialesRequest materialesRequest);
	public ResponseServiceObject findByid(Integer idProducto) throws ServiceException;
}
