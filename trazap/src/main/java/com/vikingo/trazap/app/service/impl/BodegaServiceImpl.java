package com.vikingo.trazap.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vikingo.trazap.app.dto.BodegaDto;
import com.vikingo.trazap.app.repository.BodegaRepository;
import com.vikingo.trazap.app.repository.model.Bodega;
import com.vikingo.trazap.app.service.BodegaService;

public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository bodegaRepository;
	private BodegaDto bodegaDto;
	
	@Override
	public BodegaDto add(Bodega bodega) {
		
		return null;
	}

	
	
}
