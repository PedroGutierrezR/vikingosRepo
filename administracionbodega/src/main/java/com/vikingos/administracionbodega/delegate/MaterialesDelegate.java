package com.vikingos.administracionbodega.delegate;

import com.vikingos.administracionbodega.exception.ServiceException;
import com.vikingos.administracionbodega.request.MaterialesRequest;
import com.vikingos.administracionbodega.service.response.ResponseServiceObject;

public interface MaterialesDelegate {

	public ResponseServiceObject findAll();
	//save crea y actualiza
	public ResponseServiceObject save(MaterialesRequest materialesRequest);
	public ResponseServiceObject save(int idProducto, MaterialesRequest materialesRequest);
	public ResponseServiceObject findByid(Integer idProducto) throws ServiceException;
}
