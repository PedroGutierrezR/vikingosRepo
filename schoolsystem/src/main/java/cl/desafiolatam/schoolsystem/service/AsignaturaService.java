package cl.desafiolatam.schoolsystem.service;

import cl.desafiolatam.schoolsystem.dto.AsignaturaDto;

public interface AsignaturaService {

	public AsignaturaDto getAsignaturas();
	public int updateAsignatura(AsignaturaDto asignaturaDto);
	public int addAsignatura(AsignaturaDto asignaturaDto);
	
}
