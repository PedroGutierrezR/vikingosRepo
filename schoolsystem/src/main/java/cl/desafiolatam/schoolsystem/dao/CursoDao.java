package cl.desafiolatam.schoolsystem.dao;

import java.util.List;

import cl.desafiolatam.schoolsystem.dao.model.Alumno;
import cl.desafiolatam.schoolsystem.dao.model.Curso;

public interface CursoDao {
	public int add(Curso curso);
	public List<Curso> getAll();
	public Alumno getById(int idCurso);
	public int update(Curso alumno);
	public int deleteById(int idCurso);
}
