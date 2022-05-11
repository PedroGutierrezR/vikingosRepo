package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.TrazabilidadDelegate;
import com.vikingo.trazap.app.exceptions.ServiceException;
//import com.vikingo.trazap.app.repository.model.Trazabilidad;
import com.vikingo.trazap.app.service.TrazabilidadService;
import com.vikingo.trazap.app.service.request.TrazabilidadRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;


@Component("trazabilidadDelegate")
public class TrazabilidadDelegateImpl implements TrazabilidadDelegate {

	@Autowired
	private TrazabilidadService trazabilidadService;
	
	@Override
	public ResponseServiceObject findAll() {
		// TODO Auto-generated method stub
		return trazabilidadService.findAll();
	}

	@Override
	public ResponseServiceObject save(TrazabilidadRequest trazabilidadRequest) {
		// TODO Auto-generated method stub
		return trazabilidadService.save(trazabilidadRequest);
	}

	@Override
	public ResponseServiceObject save(int idTrazabilidad,TrazabilidadRequest trazabilidadRequest) {
		return trazabilidadService.save(idTrazabilidad, trazabilidadRequest);
	}

	@Override
	public ResponseServiceObject findByid(Integer idTrazabilidad) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject deleteById(TrazabilidadRequest trazabilidadRequest) {
		// TODO Auto-generated method stub
		return trazabilidadService.deleteById(trazabilidadRequest) ;
	}	
}
