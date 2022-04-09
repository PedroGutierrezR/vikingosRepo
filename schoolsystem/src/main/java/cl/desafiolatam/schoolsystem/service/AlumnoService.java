package cl.desafiolatam.schoolsystem.service;

import cl.desafiolatam.schoolsystem.dto.AlumnoDto;

public interface AlumnoService {
	public AlumnoDto getAlumnos();
	public int addAlumnos(AlumnoDto alumnoDto);
	public int deleteById(int idAlumno);
	public int update(AlumnoDto idAlumno);
}
