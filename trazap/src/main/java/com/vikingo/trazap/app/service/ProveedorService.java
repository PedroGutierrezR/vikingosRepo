package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.repository.model.Proveedor;
import com.vikingo.trazap.app.service.request.ProveedorRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface ProveedorService {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Proveedor proveedores);
	public void deleteById(ProveedorRequest proveedorRequest);
	public ResponseServiceObject save(int idProveedor, ProveedorRequest proveedorRequest);
	public ResponseServiceObject findByid(Integer idProveedor) throws ServiceException;
}
