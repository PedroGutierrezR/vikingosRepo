package com.vikingo.trazap.app.delegate;

//import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.repository.model.Trazabilidad;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface TrazabilidadDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(Trazabilidad trazabilidad);
}
