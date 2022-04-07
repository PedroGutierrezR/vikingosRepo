package cl.desafiolatam.schoolsystem.dao;

import java.util.List;
import cl.desafiolatam.schoolsystem.dao.model.Asignatura;

public interface AsignaturaDao {

	public int add(Asignatura asignatura);
	public List<Asignatura> getAll();
	public Asignatura getById(int idAsignatura);
	public int update(Asignatura asignatura);
	
}
