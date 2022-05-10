package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.service.request.TrazabilidadRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface TrazabilidadDelegate {

	public ResponseServiceObject findAll();
	public ResponseServiceObject save(int idTrazabilidad, TrazabilidadRequest trazabilidadRequest);
	public ResponseServiceObject save(TrazabilidadRequest trazabilidadRequest);
	public ResponseServiceObject findByid(Integer idTrazabilidad) throws ServiceException;
	public ResponseServiceObject deleteById(TrazabilidadRequest trazabilidadRequest);
}
