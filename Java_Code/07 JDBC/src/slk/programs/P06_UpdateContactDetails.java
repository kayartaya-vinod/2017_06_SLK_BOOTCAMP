package slk.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import slk.util.DbUtil;
import slk.util.KeyboardUtil;

public class P06_UpdateContactDetails {

	public static void main(String[] args) throws Exception {
		
		Connection conn = DbUtil.getConnection();
		String sql = "select * from contacts where id = ?";
		PreparedStatement stmt1 = conn.prepareStatement(sql);
		
		int id = KeyboardUtil.getInt("Enter the contact's id: ");
		stmt1.setInt(1, id);
		ResultSet rs = stmt1.executeQuery();
		
		if(rs.next()){
			sql = "update contacts set name = ?, email = ?, phone = ?, city = ?, gender = ? where id = ?";
			PreparedStatement stmt2 = conn.prepareStatement(sql);
			
			String name = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String city = rs.getString("city");
			String gender = rs.getString("gender");
			
			String input = KeyboardUtil.getString("Enter name (" + name + "): ");
			if(input.trim().length()!=0){
				name = input;
			}
			input = KeyboardUtil.getString("Enter email (" + email + "): ");
			if(input.trim().length()!=0){
				email = input;
			}
			input = KeyboardUtil.getString("Enter phone (" + phone + "): ");
			if(input.trim().length()!=0){
				phone = input;
			}
			input = KeyboardUtil.getString("Enter city (" + city + "): ");
			if(input.trim().length()!=0){
				city = input;
			}
			input = KeyboardUtil.getString("Enter gender (" + gender + "): ");
			if(input.trim().length()!=0){
				gender = input;
			}
			
			stmt2.setString(1, name);
			stmt2.setString(2, email);
			stmt2.setString(3, phone);
			stmt2.setString(4, city);
			stmt2.setString(5, gender);
			stmt2.setInt(6, id);
			
			stmt2.executeUpdate();
			System.out.println("Data updated successfully!");
			stmt2.close();
		}
		else {
			System.out.println("Invalid id. No data found for id " + id);
		}
		
		rs.close();
		stmt1.close();
		conn.close();
	}
}








