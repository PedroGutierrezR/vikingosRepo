package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.repository.model.Proveedores;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;


public interface ProveedoresDelegate {
	
	  public ResponseServiceObject findAll();

	    public ResponseServiceObject save(Proveedores proveedores);

}
