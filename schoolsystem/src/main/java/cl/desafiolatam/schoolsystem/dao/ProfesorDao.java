package cl.desafiolatam.schoolsystem.dao;

import java.util.List;

import cl.desafiolatam.schoolsystem.dao.model.Alumno;

//import java.util.List;

//import cl.desafiolatam.schoolsystem.dao.model.Asignatura;
//import cl.desafiolatam.schoolsystem.dao.model.Alumno;
//import cl.desafiolatam.schoolsystem.dao.model.Curso;
import cl.desafiolatam.schoolsystem.dao.model.Profesor;

public interface ProfesorDao {
	
	
	public int add(Profesor profesor);
	public List<Profesor> getAll();
	public Profesor getById(int idProfesor);
	public int update(Profesor profesor);
	public int delete(int idProfesor);
	

}
