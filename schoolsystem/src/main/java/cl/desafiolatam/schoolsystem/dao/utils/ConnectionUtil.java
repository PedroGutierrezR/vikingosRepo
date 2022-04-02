package cl.desafiolatam.schoolsystem.dao.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {
	private static Context initContext;
	private static Connection cn = null;
	
	public static Connection getConnection() throws NamingException, SQLException {
		initContext = new InitialContext();
	    DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/ConexionOracle");
	    cn = ds.getConnection();
		return cn;
	}
	
	public static void closeConnection() throws SQLException {
		if(cn != null) {
			cn.close();
		}
	}
}
