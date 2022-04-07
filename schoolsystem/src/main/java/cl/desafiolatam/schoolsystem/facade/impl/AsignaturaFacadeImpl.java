package cl.desafiolatam.schoolsystem.facade.impl;

import cl.desafiolatam.schoolsystem.dto.AsignaturaDto;
import cl.desafiolatam.schoolsystem.facade.AsignaturaFacade;
import cl.desafiolatam.schoolsystem.service.AsignaturaService;
import cl.desafiolatam.schoolsystem.service.impl.AsignaturaServiceImpl;

public class AsignaturaFacadeImpl implements AsignaturaFacade {

	private AsignaturaService asignaturaService = null;
	
	public AsignaturaFacadeImpl() {
		this.asignaturaService = new AsignaturaServiceImpl(); 
	}
	
	@Override
	public AsignaturaDto getAsignaturas() {
		return asignaturaService.getAsignaturas();
	}

	@Override
	public int updateAsignatura(AsignaturaDto asignaturaDto) {
		return asignaturaService.updateAsignatura(asignaturaDto);
	}

	@Override
	public int addAsignatura(AsignaturaDto asignaturaDto) {
		return asignaturaService.addAsignatura(asignaturaDto);
	}

}
