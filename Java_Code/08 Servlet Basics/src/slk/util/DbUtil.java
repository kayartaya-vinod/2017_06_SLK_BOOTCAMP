package slk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import slk.dao.DaoException;

public class DbUtil {

	public static Connection getConnection() throws DaoException {
		try {
			String driverClassName = "org.hsqldb.jdbcDriver";
			String url = "jdbc:hsqldb:hsql://localhost:9001/training";
			String username = "sa";
			String password = "";

			Class.forName(driverClassName);

			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public static void closeResources(Connection conn, Statement stmt, ResultSet rs) throws DaoException {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
}
