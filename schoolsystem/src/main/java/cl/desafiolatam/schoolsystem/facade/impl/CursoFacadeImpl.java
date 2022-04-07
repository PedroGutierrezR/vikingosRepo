package cl.desafiolatam.schoolsystem.facade.impl;

import cl.desafiolatam.schoolsystem.dto.CursoDto;
import cl.desafiolatam.schoolsystem.facade.CursoFacade;
import cl.desafiolatam.schoolsystem.service.CursoService;
import cl.desafiolatam.schoolsystem.service.impl.CursoServiceImpl;

public class CursoFacadeImpl implements CursoFacade{
	
	CursoService cursoService = null;
	
	public CursoFacadeImpl() {
		super();
		this.cursoService = new CursoServiceImpl();
	}

	@Override
	public CursoDto getCursos() {
		return this.cursoService.getCursos();
	}

	@Override
	public int updateCurso(CursoDto cursoDto) {
		return cursoService.updateCurso(cursoDto);
	}

	@Override
	public int addCurso(CursoDto cursoDto) {
		return cursoService.addCurso(cursoDto);
	}

}
