package cl.desafiolatam.schoolsystem.facade;

import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.CursoDto;

public interface CursoFacade {
	public CursoDto getCursos();

	public int update(AlumnoDto alumnoDto);
}
