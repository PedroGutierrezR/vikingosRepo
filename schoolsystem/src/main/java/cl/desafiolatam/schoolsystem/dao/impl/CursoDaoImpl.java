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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Curso> getAll() {
		
		Connection cn = null;
		List<Curso> cursos = null;
		try {
			cn = ConnectionUtil.getConnection();
			Statement st = cn.createStatement();
			ResultSet rset = st.executeQuery("SELECT id_curso, descripcion\r\n"
					+ "	FROM curso");
			cursos = new ArrayList<Curso>();
			while(rset.next()) {
				Curso curso = new Curso();
				
				curso.setIdCurso(rset.getInt("id_curso"));
				curso.setDescripcion(rset.getString("descripcion"));
				
				cursos.add(curso);
			}
			
			rset.close();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
