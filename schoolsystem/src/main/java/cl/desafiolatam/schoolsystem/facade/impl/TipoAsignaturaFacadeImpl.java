package cl.desafiolatam.schoolsystem.facade.impl;

import cl.desafiolatam.schoolsystem.dto.TipoAsignaturaDto;
import cl.desafiolatam.schoolsystem.facade.TipoAsignaturaFacade;
import cl.desafiolatam.schoolsystem.service.TipoAsignaturaService;
import cl.desafiolatam.schoolsystem.service.impl.TipoAsignaturaServiceImpl;

public class TipoAsignaturaFacadeImpl implements TipoAsignaturaFacade {

	private TipoAsignaturaService tipoAsignaturaService = null;
	
	public TipoAsignaturaFacadeImpl() {
		this.tipoAsignaturaService = new TipoAsignaturaServiceImpl();
	}
	
	@Override
	public TipoAsignaturaDto getAll() {
		return tipoAsignaturaService.getAll();
	}

}
