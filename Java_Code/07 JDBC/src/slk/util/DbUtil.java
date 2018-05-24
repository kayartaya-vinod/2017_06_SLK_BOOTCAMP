package slk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		 String driverClassName = "org.hsqldb.jdbcDriver";
		 String url = "jdbc:hsqldb:hsql://localhost:9001/training";
		 String username = "sa";
		 String password = "";
		
		// String driverClassName = "com.mysql.jdbc.Driver";
		// String url = "jdbc:mysql://localhost/training";
		// String username = "root";
		// String password = "root";

		// Step 1: load the driver class to JVM
		// when the driver is loaded to the VM, it will instantiate itself, and
		// registers with the DriverManager class
		Class.forName(driverClassName);

		// Step 2: open a connection to the database
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
}
