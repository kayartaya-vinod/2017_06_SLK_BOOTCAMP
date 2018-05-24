package slk.programs;

import java.sql.Connection;
import java.sql.Statement;

import slk.util.DbUtil;
import slk.util.KeyboardUtil;

public class P03_InsertMultipleContacts {
	public static void main(String[] args) throws Exception {
		Connection conn = DbUtil.getConnection();
		Statement stmt = conn.createStatement();
		
		
		while (true) {
			System.out.println("Enter contact details:");
			int id = KeyboardUtil.getInt("Id: ");
			String name = KeyboardUtil.getString("Name: ");
			String email = KeyboardUtil.getString("Email: ");
			String phone = KeyboardUtil.getString("Phone: ");
			String city = KeyboardUtil.getString("City: ");
			String gender = KeyboardUtil.getString("Gender: ");
			String sql = String.format("insert into contacts values(%d, '%s', '%s', '%s', '%s', '%s')", id, name, email,
					phone, city, gender);
			
			stmt.addBatch(sql);
			
			String choice = KeyboardUtil.getString("Enter 'quit' to exit, hit RETURN to add another: ");
			if(choice.equalsIgnoreCase("quit")){
				break;
			}
		} // end of while loop
		
		stmt.executeBatch();
		
		stmt.close();
		conn.close();
		
		System.out.println("Data inserted!");
	}
}









