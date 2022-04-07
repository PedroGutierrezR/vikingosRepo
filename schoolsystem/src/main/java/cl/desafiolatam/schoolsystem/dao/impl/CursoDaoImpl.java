package cl.desafiolatam.schoolsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		Connection cn = null;
		int resultado = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement st = cn.prepareStatement("INSERT INTO curso(id_curso, descripcion) VALUES (?, ?)");
				
			int lastId = getLastId();
			
			st.setInt(1, (lastId + 1));
			st.setString(2, curso.getDescripcion());
			resultado = st.executeUpdate();
			
			st.close();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultado;
	}

	@Override
	public List<Curso> getAll() {
		
		Connection cn = null;
		List<Curso> cursos = null;
		
		try {
			cn = ConnectionUtil.getConnection();
			Statement st = cn.createStatement();
			ResultSet rset = st.executeQuery("SELECT c.id_curso, c.descripcion FROM curso c ORDER BY c.id_curso");
			cursos = new ArrayList<Curso>();
			
			while(rset.next()) {

				Curso curso = new Curso();
				curso.setIdCurso(rset.getInt("id_curso"));
				curso.setDescripcion(rset.getString("descripcion"));
				cursos.add(curso);
				
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
		return null;
	}

	@Override
	public int update(Curso curso) {
		
		String sql = "UPDATE curso SET descripcion = ? WHERE id_curso = ?";
		
		Connection cn = null;
		int resultado = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement st = cn.prepareStatement(sql);
			
			st.setString(1, curso.getDescripcion());
			st.setInt(2, curso.getIdCurso());
				
			resultado = st.executeUpdate();
			
			st.close();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultado;
		
	}

	@Override
	public int deleteById(int idCurso) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getLastId() {
		
		Connection cn = null;
		int lastId = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement pt = cn.prepareStatement("SELECT MAX(id_curso) AS max FROM curso");
			ResultSet rset = pt.executeQuery();
			
			if(rset.next()) {
				lastId = rset.getInt("max");
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
		return lastId;
	}
	
}
