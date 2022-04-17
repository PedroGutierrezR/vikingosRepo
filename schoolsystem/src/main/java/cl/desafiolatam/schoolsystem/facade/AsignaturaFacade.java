package cl.desafiolatam.schoolsystem.facade;

import cl.desafiolatam.schoolsystem.dto.AsignaturaDto;

public interface AsignaturaFacade {

	public AsignaturaDto getAsignaturas();
	public int updateAsignatura(AsignaturaDto asignaturaDto);
	public int addAsignatura(AsignaturaDto asignaturaDto);
	
}
