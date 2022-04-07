package cl.desafiolatam.schoolsystem.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import cl.desafiolatam.schoolsystem.dao.AsignaturaDao;
import cl.desafiolatam.schoolsystem.dao.model.Asignatura;
import cl.desafiolatam.schoolsystem.dao.utils.ConnectionUtil;

public class AsignaturaDaoImpl implements AsignaturaDao {

	@Override
	public int add(Asignatura asignatura) {
		return 0;
	}

	@Override
	public List<Asignatura> getAll() {
		Connection cn = null;
		List<Asignatura> asignaturas = null;

		try {
			cn = ConnectionUtil.getConnection();
			Statement st = cn.createStatement();
			ResultSet rset = st.executeQuery("SELECT id_asignatura, descripcion FROM asignatura ORDER BY c.id_asignatura");
			asignaturas = new ArrayList<Asignatura>();

			while (rset.next()) {

				Asignatura asignatura = new Asignatura();
				asignatura.setIdAsignatura(rset.getInt("id_asignatura"));
				asignatura.setDecripcion(rset.getString("descripcion"));
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
		return 0;
	}

}
