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
		this.cursoService = new CursoServiceImpl();
	}

	@Override
	public CursoDto getCursos() {
		return this.cursoService.getCursos();
	}

<<<<<<< HEAD


	@Override
	public int update(AlumnoDto alumnoDto) {
		// TODO Auto-generated method stub
		return 0;
=======
	@Override
	public int updateCurso(CursoDto cursoDto) {
		return cursoService.updateCurso(cursoDto);
	}

	@Override
	public int addCurso(CursoDto cursoDto) {
		return cursoService.addCurso(cursoDto);
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
	}

}
