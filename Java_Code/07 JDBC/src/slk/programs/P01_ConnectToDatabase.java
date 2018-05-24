package slk.programs;

import java.sql.Connection;
import java.sql.SQLException;

import slk.util.DbUtil;

public class P01_ConnectToDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection conn = DbUtil.getConnection();
		System.out.println("conn refers to an object of " + conn.getClass());
		conn.close(); 
	}

	
}
