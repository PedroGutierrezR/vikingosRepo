package cl.desafiolatam.schoolsystem.facade;

import cl.desafiolatam.schoolsystem.dto.AlumnoDto;

public interface AlumnoFacade {
	public AlumnoDto getAlumnos();
	public AlumnoDto addAlumno(AlumnoDto alumnoDto);
	public int deleteById(int idAlumno);
}
