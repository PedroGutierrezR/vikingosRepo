package cl.desafiolatam.schoolsystem.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import cl.desafiolatam.schoolsystem.dao.TipoAsignaturaDao;
import cl.desafiolatam.schoolsystem.dao.model.TipoAsignatura;
import cl.desafiolatam.schoolsystem.dao.utils.ConnectionUtil;

public class TipoAsignaturaDaoImpl implements TipoAsignaturaDao{

	@Override
	public List<TipoAsignatura> getAll() {

		Connection cn = null;
		List<TipoAsignatura> tipoAsignaturas = null;

		try {
			cn = ConnectionUtil.getConnection();
			Statement st = cn.createStatement();
			ResultSet rset = st.executeQuery("SELECT id_tipo_asignatura, descripcion FROM tipo_asignatura ORDER BY id_tipo_asignatura");
			tipoAsignaturas = new ArrayList<TipoAsignatura>();

			while (rset.next()) {

				TipoAsignatura tipoAsignatura = new TipoAsignatura();
				tipoAsignatura.setIdTipoAsignatura(rset.getInt(1));
				tipoAsignatura.setDescripcion(rset.getString(2));
				tipoAsignaturas.add(tipoAsignatura);

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
		return tipoAsignaturas;
		
	}

}
