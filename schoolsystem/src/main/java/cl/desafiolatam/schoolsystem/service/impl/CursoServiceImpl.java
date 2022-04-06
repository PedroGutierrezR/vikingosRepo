package cl.desafiolatam.schoolsystem.service.impl;

import cl.desafiolatam.schoolsystem.dao.CursoDao;
import cl.desafiolatam.schoolsystem.dao.impl.CursoDaoImpl;
import cl.desafiolatam.schoolsystem.dto.CursoDto;
import cl.desafiolatam.schoolsystem.service.CursoService;

public class CursoServiceImpl implements CursoService{
	private CursoDao cursoDao = null;
	
	public CursoServiceImpl() {
		super();
		this.cursoDao = new CursoDaoImpl();
	}
	
	@Override
	public CursoDto getCursos() {
		CursoDto cursoDto = new CursoDto();
		cursoDto.setCursos(this.cursoDao.getAll());
		return cursoDto;
	}

}
