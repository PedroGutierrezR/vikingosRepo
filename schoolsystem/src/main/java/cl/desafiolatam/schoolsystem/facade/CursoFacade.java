package cl.desafiolatam.schoolsystem.facade;

import cl.desafiolatam.schoolsystem.dto.AlumnoDto;
import cl.desafiolatam.schoolsystem.dto.CursoDto;

public interface CursoFacade {
	public CursoDto getCursos();
<<<<<<< HEAD

	public int update(AlumnoDto alumnoDto);
=======
	public int updateCurso(CursoDto cursoDto);
	public int addCurso(CursoDto cursoDto);
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
}
