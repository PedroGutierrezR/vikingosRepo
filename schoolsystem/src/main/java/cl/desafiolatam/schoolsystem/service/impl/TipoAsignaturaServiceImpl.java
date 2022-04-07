package cl.desafiolatam.schoolsystem.service.impl;

import cl.desafiolatam.schoolsystem.dao.TipoAsignaturaDao;
import cl.desafiolatam.schoolsystem.dao.impl.TipoAsignaturaDaoImpl;
import cl.desafiolatam.schoolsystem.dto.TipoAsignaturaDto;
import cl.desafiolatam.schoolsystem.service.TipoAsignaturaService;

public class TipoAsignaturaServiceImpl implements TipoAsignaturaService{

	private TipoAsignaturaDao tipoAsignaturaDao = null;
	
	public TipoAsignaturaServiceImpl() {
		this.tipoAsignaturaDao = new TipoAsignaturaDaoImpl();
	}
	
	@Override
	public TipoAsignaturaDto getAll() {
		TipoAsignaturaDto tipoAsignaturaDto = new TipoAsignaturaDto();
		tipoAsignaturaDto.setTipoAsignaturas(tipoAsignaturaDao.getAll());
		return tipoAsignaturaDto;
	}

}
