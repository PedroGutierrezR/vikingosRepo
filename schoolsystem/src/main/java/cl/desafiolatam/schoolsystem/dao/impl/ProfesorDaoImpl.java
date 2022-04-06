package cl.desafiolatam.schoolsystem.dao.impl;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.naming.NamingException;

import cl.desafiolatam.schoolsystem.dao.ProfesorDao;
//import cl.desafiolatam.schoolsystem.dao.model.Alumno;
//import cl.desafiolatam.schoolsystem.dao.model.Curso;
//import cl.desafiolatam.schoolsystem.dao.model.Alumno;
//import cl.desafiolatam.schoolsystem.dao.model.Asignatura;
//import cl.desafiolatam.schoolsystem.dao.model.Curso;
import cl.desafiolatam.schoolsystem.dao.model.Profesor;
import cl.desafiolatam.schoolsystem.dao.utils.ConnectionUtil;

public class ProfesorDaoImpl implements ProfesorDao{

	@Override
	public int add(Profesor profesor) {
		// TODO Auto-generated method stub
		//return 0;
		
		Connection cn = null;
		int resultado = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement st = cn.prepareStatement("INSERT INTO profesor(id_profesor, nombre, apellido,) VALUES (?, ?, ?)");
			
			//Al cambiar el componente del modal a date, la fecha ya l envía en el formato corecto - YYYY-MM-DD
			//String fechaDb = Utils.getFechaDB(alumno.getFechaNac());
			
			int lastId = getLastId();
			
			st.setInt(1, (lastId + 1));
			st.setString(2, profesor.getNombre());
			st.setString(3, profesor.getApellido());
		

			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultado;
	}
		
	private int getLastId() {
		// TODO Auto-generated method stub
		//return 0;
		
		Connection cn = null;
		int lastId = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement pt = cn.prepareStatement("SELECT MAX(ID_PROFESOR) AS max FROM PROFESOR");
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
	

	@Override
	public Profesor getById(int idProfesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Profesor profesor) {
		// TODO Auto-generated method stub
		//return 0;
		
		String sql = "UPDATE profesor SET nombre = ?, apellido = ?, WHERE id_profesor = ?";
		
		Connection cn = null;
		int resultado = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement st = cn.prepareStatement(sql);
			
			st.setString(1, profesor.getNombre());
			st.setString(2, profesor.getApellido());
			st.setInt(5, profesor.getId_profesor());

				
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultado;
		

	}

	@Override
	public int delete(int idProfesor) {
		// TODO Auto-generated method stub
		//return 0;
		
		String sql = "DELETE FROM profesor WHERE id_profesor = ?";
		
		Connection cn = null;
		int resultado = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement st = cn.prepareStatement(sql);
	
			st.setInt(1, idProfesor);
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultado;
	}

	@Override
	public List<Profesor> getAll() {
		// TODO Auto-generated method stub
		//return null;
		
		Connection cn = null;
		List<Profesor> profesores = null;
		try {
			cn = ConnectionUtil.getConnection();
			Statement st = cn.createStatement();
			ResultSet rset = st.executeQuery("SELECT id_profesor,nombre, apellido FROM profesor ORDER BY id_profesor");
			profesores = new ArrayList<Profesor>();
			while(rset.next()) {
				Profesor profesor = new Profesor();
				//Curso curso = new Curso();
				//curso.setIdCurso(rset.getInt("curso_id"));
				//curso.setDescripcion(rset.getString("descripcion"));
				
				//alumno.setCurso(curso);
				profesor.setId_profesor(rset.getInt("id_profesor"));
				profesor.setNombre(rset.getString("nombre"));
				profesor.setApellido(rset.getString("apellido"));
				//alumno.setFechaNac(rset.getDate("fecha_nac").toString());
				profesores.add(profesor);
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

		
		return profesores;
	}


}
