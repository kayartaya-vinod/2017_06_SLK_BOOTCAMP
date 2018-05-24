package slk.programs;

import java.sql.Connection;
import java.sql.Statement;

import slk.util.DbUtil;
import slk.util.KeyboardUtil;

public class P02_InsertNewContact {
	public static void main(String[] args) throws Exception {
		
		System.out.println("Enter contact details:");
		int id = KeyboardUtil.getInt("Id: ");
		String name = KeyboardUtil.getString("Name: ");
		String email = KeyboardUtil.getString("Email: ");
		String phone = KeyboardUtil.getString("Phone: ");
		String city = KeyboardUtil.getString("City: ");
		String gender = KeyboardUtil.getString("Gender: ");
		
		Connection conn = DbUtil.getConnection();
		
		String sql = String.format(
			"insert into contacts values(%d, '%s', '%s', '%s', '%s', '%s')", 
			id, name, email, phone, city, gender);
		
		Statement stmt = conn.createStatement();
		try {
			// boolean execute(sql) --> any sql 
			// int executeUpdate(sql) --> DML
			// ResultSet executeQuery(sql) --> Only query (SELECT)
			// int[] executeBatch() --> executes all sql commands added via addBatch(sql)
			
			stmt.executeUpdate(sql);
			System.out.println("data inserted!");
		} catch (Exception e) {
			System.out.println("Something went wrong! " + e.getMessage());
		}
		
		stmt.close();
		conn.close();
		
	}
}









