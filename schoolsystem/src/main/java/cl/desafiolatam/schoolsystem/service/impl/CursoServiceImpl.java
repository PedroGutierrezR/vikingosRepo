package cl.desafiolatam.schoolsystem.service.impl;

import cl.desafiolatam.schoolsystem.dao.CursoDao;
import cl.desafiolatam.schoolsystem.dao.impl.CursoDaoImpl;
import cl.desafiolatam.schoolsystem.dto.CursoDto;
import cl.desafiolatam.schoolsystem.service.CursoService;

public class CursoServiceImpl implements CursoService{
	private CursoDao cursoDao = null;
	
	

	public CursoServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.cursoDao = new CursoDaoImpl();
	}



	@Override
	public CursoDto getCursos() {
		// TODO Auto-generated method stub
		CursoDto cursoDto = new CursoDto();
		cursoDto.setCursos(this.cursoDao.getAll());
		return cursoDto;
	}

}
