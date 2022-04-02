package cl.desafiolatam.schoolsystem.dao;

import java.util.List;

import cl.desafiolatam.schoolsystem.dao.model.Alumno;

public interface AlumnoDao {
	public int add(Alumno alumno);
	public List<Alumno> getAll();
	public Alumno getById(int idalumno);
	public int update(Alumno alumno);
	public int deleteById(int idAlumno);
}
