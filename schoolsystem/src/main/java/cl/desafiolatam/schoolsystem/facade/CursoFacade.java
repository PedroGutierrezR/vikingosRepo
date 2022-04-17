package cl.desafiolatam.schoolsystem.facade;

import cl.desafiolatam.schoolsystem.dto.CursoDto;

public interface CursoFacade {
	public CursoDto getCursos();
	public int updateCurso(CursoDto cursoDto);
	public int addCurso(CursoDto cursoDto);
}
