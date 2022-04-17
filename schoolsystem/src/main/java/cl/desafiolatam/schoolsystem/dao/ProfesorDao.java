package cl.desafiolatam.schoolsystem.dao;

import java.util.List;



//import java.util.List;

//import cl.desafiolatam.schoolsystem.dao.model.Asignatura;
//import cl.desafiolatam.schoolsystem.dao.model.Alumno;
//import cl.desafiolatam.schoolsystem.dao.model.Curso;
import cl.desafiolatam.schoolsystem.dao.model.Profesor;

public interface ProfesorDao {
	
	
	public int add(Profesor profesor);
	public List<Profesor> getAll();
	public Profesor getById(int id_profesor);
	public int update(Profesor profesor);
	public int delete(int id_profesor);
	

}
