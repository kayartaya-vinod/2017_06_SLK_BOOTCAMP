package slk.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;

import slk.util.DbUtil;
import slk.util.KeyboardUtil;

public class P04_InsertMultipleContacts {
	public static void main(String[] args) throws Exception {
		Connection conn = DbUtil.getConnection();
		String sql = "insert into contacts values(?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		// The above method call sends the sql-like command to the RDBMS,
		// which compiles it, creates a suitable execution plan, 
		// stores the plan, and returns a unique plan-id using which a
		// new instance of PreparedStatement implementation is created
		
		while (true) {
			System.out.println("Enter contact details:");
			int id = KeyboardUtil.getInt("Id: ");
			String name = KeyboardUtil.getString("Name: ");
			String email = KeyboardUtil.getString("Email: ");
			String phone = KeyboardUtil.getString("Phone: ");
			String city = KeyboardUtil.getString("City: ");
			String gender = KeyboardUtil.getString("Gender: ");
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, phone);
			stmt.setString(5, city);
			stmt.setString(6, gender);
			
			stmt.executeUpdate();
			// The above statement carries all the values to the RDBMS along with
			// the execution plan id, which is used by the RDBMS to locate the plan,
			// execute the plan with the given data, and return the result of
			// this operation.
			
			String choice = KeyboardUtil.getString("Enter 'quit' to exit, hit RETURN to add another: ");
			if(choice.equalsIgnoreCase("quit")){
				break;
			}
		} // end of while loop
		
		stmt.close();
		conn.close();
		
		System.out.println("Data inserted!");
	}
}









