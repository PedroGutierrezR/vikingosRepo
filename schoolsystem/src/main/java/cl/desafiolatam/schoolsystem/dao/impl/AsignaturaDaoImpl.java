package cl.desafiolatam.schoolsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import cl.desafiolatam.schoolsystem.dao.AsignaturaDao;
import cl.desafiolatam.schoolsystem.dao.model.Asignatura;
import cl.desafiolatam.schoolsystem.dao.model.TipoAsignatura;
import cl.desafiolatam.schoolsystem.dao.utils.ConnectionUtil;

public class AsignaturaDaoImpl implements AsignaturaDao {

	@Override
	public int add(Asignatura asignatura) {
		Connection cn = null;
		int resultado = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement st = cn.prepareStatement("INSERT INTO asignatura(id_asignatura, descripcion, tipo_asignatura_id) VALUES (?, ?, ?)");
				
			int lastId = getLastId();
			
			st.setInt(1, (lastId + 1));
			st.setString(2, asignatura.getDescripcion());
			System.out.println(asignatura.getTipoAsignatura().getIdTipoAsignatura());
			st.setInt(3, asignatura.getTipoAsignatura().getIdTipoAsignatura());
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
	public List<Asignatura> getAll() {
		Connection cn = null;
		List<Asignatura> asignaturas = null;

		try {
			cn = ConnectionUtil.getConnection();
			Statement st = cn.createStatement();
			ResultSet rset = st.executeQuery("SELECT a.id_asignatura, a.descripcion, a.tipo_asignatura_id, t.descripcion FROM asignatura a INNER JOIN tipo_asignatura t ON t.id_tipo_asignatura = a.tipo_asignatura_id ORDER BY a.id_asignatura");
			asignaturas = new ArrayList<Asignatura>();

			while (rset.next()) {

				Asignatura asignatura = new Asignatura();
				TipoAsignatura tipoAsignatura = new TipoAsignatura();
				asignatura.setIdAsignatura(rset.getInt(1));
				asignatura.setDescripcion(rset.getString(2));
				tipoAsignatura.setIdTipoAsignatura(rset.getInt(3));
				tipoAsignatura.setDescripcion(rset.getString(4));
				asignatura.setTipoAsignatura(tipoAsignatura);
				asignaturas.add(asignatura);

			}

			rset.close();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return asignaturas;

	}

	@Override
	public Asignatura getById(int idAsignatura) {
		return null;
	}

	@Override
	public int update(Asignatura asignatura) {
		
		String sql = "UPDATE asignatura SET descripcion = ?, tipo_asignatura_id = ? WHERE id_asignatura = ?";
		
		Connection cn = null;
		int resultado = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement st = cn.prepareStatement(sql);
			
			st.setString(1, asignatura.getDescripcion());
			st.setInt(2, asignatura.getTipoAsignatura().getIdTipoAsignatura());
			st.setInt(3, asignatura.getIdAsignatura());
				
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
	
	public int getLastId() {
		
		Connection cn = null;
		int lastId = 0;
		try {
			cn = ConnectionUtil.getConnection();
			PreparedStatement pt = cn.prepareStatement("SELECT MAX(id_asignatura) AS max FROM asignatura");
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
