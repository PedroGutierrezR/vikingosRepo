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
import cl.desafiolatam.schoolsystem.dao.model.TipoAsignatura;
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
		return 0;
	}

}
