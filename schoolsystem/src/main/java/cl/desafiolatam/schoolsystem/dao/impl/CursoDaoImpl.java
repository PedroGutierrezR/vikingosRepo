package cl.desafiolatam.schoolsystem.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import cl.desafiolatam.schoolsystem.dao.CursoDao;
import cl.desafiolatam.schoolsystem.dao.model.Alumno;
import cl.desafiolatam.schoolsystem.dao.model.Curso;
import cl.desafiolatam.schoolsystem.dao.utils.ConnectionUtil;

public class CursoDaoImpl implements CursoDao{

	@Override
	public int add(Curso curso) {
		
		return 0;
	}

	@Override
	public List<Curso> getAll() {
		
		Connection cn = null;
		List<Curso> cursos = null;
		List<Alumno> alumnos = null;
		
		try {
			cn = ConnectionUtil.getConnection();
			Statement st = cn.createStatement();
			ResultSet rset = st.executeQuery("SELECT c.id_curso, c.descripcion, a.id_alumno, a.nombre, a.apellido, a.fecha_nac FROM curso c INNER JOIN alumno a ON c.id_curso = a.curso_id");
			cursos = new ArrayList<Curso>();
			alumnos = new ArrayList<Alumno>();
			int idAnterior = 0;
			
			while(rset.next()) {
									
				if (idAnterior != rset.getInt("id_curso")) {
					Curso curso = new Curso();
					curso.setIdCurso(rset.getInt("id_curso"));
					curso.setDescripcion(rset.getString("descripcion"));
					cursos.add(curso);
					idAnterior = rset.getInt("id_curso");
				}

				Alumno alumno = new Alumno();		
				alumno.setIdAlumno(rset.getInt("id_alumno"));
				alumno.setNombre(rset.getString("nombre"));
				alumno.setApellido(rset.getString("apellido"));
				alumno.setFechaNac(rset.getDate("fecha_nac").toString());
				alumno.setCurso(cursos.get(idAnterior - 1));
				alumnos.add(alumno);
				cursos.get(idAnterior - 1).setAlumnos(alumnos);
				
			}
			
			rset.close();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cursos;
	}

	@Override
	public Alumno getById(int idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Curso alumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int idCurso) {
		// TODO Auto-generated method stub
		return 0;
	}

}
