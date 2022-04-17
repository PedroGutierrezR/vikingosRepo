package cl.desafiolatam.schoolsystem.service;

import cl.desafiolatam.schoolsystem.dto.CursoDto;

public interface CursoService {
	public CursoDto getCursos();
	public int updateCurso(CursoDto cursoDto);
	public int addCurso(CursoDto cursoDto);
}
