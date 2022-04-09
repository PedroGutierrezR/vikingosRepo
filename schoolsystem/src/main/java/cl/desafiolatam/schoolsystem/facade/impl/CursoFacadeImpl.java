package cl.desafiolatam.schoolsystem.facade.impl;

import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.CursoDto;
import cl.desafiolatam.schoolsystem.facade.CursoFacade;
import cl.desafiolatam.schoolsystem.service.CursoService;
import cl.desafiolatam.schoolsystem.service.impl.CursoServiceImpl;

public class CursoFacadeImpl implements CursoFacade{
	CursoService cursoService = null;
	
	
	
	public CursoFacadeImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.cursoService = new CursoServiceImpl();
	}



	@Override
	public CursoDto getCursos() {
		// TODO Auto-generated method stub
		return this.cursoService.getCursos();
	}



	@Override
	public int update(AlumnoDto alumnoDto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
