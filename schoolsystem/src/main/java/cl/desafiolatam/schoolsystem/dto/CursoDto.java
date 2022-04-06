package cl.desafiolatam.schoolsystem.dto;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import cl.desafiolatam.schoolsystem.dao.model.Curso;

public class CursoDto {

	private List<Curso> cursos;

	public CursoDto() {
		super();
		this.cursos = new ArrayList<Curso>();
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	
	
}
