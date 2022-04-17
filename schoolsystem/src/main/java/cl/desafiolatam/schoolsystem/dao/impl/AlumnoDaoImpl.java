package cl.desafiolatam.schoolsystem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import cl.desafiolatam.schoolsystem.dao.AlumnoDao;
import cl.desafiolatam.schoolsystem.dao.model.Alumno;
import cl.desafiolatam.schoolsystem.dao.model.Curso;
import cl.desafiolatam.schoolsystem.dao.utils.ConnectionUtil;

public class AlumnoDaoImpl implements AlumnoDao{

	@Override
	public int add(Alumno alumno) {
		// TODO Auto-generated method stub
		Connection cn = null;
		int resultado = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement st = cn.prepareStatement("INSERT INTO alumno(id_alumno, nombre, apellido, fecha_nac, curso_id) VALUES (?, ?, ?, ?, ?)");
			
			//Al cambiar el componente del modal a date, la fecha ya l envía en el formato corecto - YYYY-MM-DD
			//String fechaDb = Utils.getFechaDB(alumno.getFechaNac());
			
			int lastId = getLastId();
			
			st.setInt(1, (lastId + 1));
			st.setString(2, alumno.getNombre());
			st.setString(3, alumno.getApellido());
			st.setDate(4, Date.valueOf(alumno.getFechaNac()));
			st.setInt(5, alumno.getCurso().getIdCurso());
	
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
	public List<Alumno> getAll() {
		Connection cn = null;
		List<Alumno> alumnos = null;
		try {
			cn = ConnectionUtil.getConnection();
			Statement st = cn.createStatement();
			ResultSet rset = st.executeQuery("SELECT a.id_alumno, a.nombre, a.apellido, a.fecha_nac, a.curso_id, c.descripcion\r\n"
					+ "	FROM alumno a, curso c where a.curso_id = c.id_curso");
			alumnos = new ArrayList<Alumno>();
			while(rset.next()) {
				Alumno alumno = new Alumno();
				Curso curso = new Curso();
				curso.setIdCurso(rset.getInt("curso_id"));
				curso.setDescripcion(rset.getString("descripcion"));
				
				alumno.setCurso(curso);
				alumno.setIdAlumno(rset.getInt("id_alumno"));
				alumno.setNombre(rset.getString("nombre"));
				alumno.setApellido(rset.getString("apellido"));
				alumno.setFechaNac(rset.getDate("fecha_nac").toString());
				alumnos.add(alumno);
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

		
		return alumnos;
	}

	@Override
	public Alumno getById(int idalumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Alumno alumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int idAlumno) {
		
		String sql = "DELETE FROM alumno WHERE id_alumno = ?";
		
		Connection cn = null;
		int resultado = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement st = cn.prepareStatement(sql);
	
			st.setInt(1, idAlumno);
			
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

	public int getLastId() {
		
		Connection cn = null;
		int lastId = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement pt = cn.prepareStatement("SELECT MAX(ID_ALUMNO) AS max FROM ALUMNO");
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
