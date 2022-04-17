package cl.desafiolatam.schoolsystem.dao;

<<<<<<< HEAD
public interface ProfesorDao {
=======
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
	
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8

}
