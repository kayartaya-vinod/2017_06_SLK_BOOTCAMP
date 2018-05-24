package slk.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import slk.util.DbUtil;

public class P05_GetAllContacts {

	public static void main(String[] args) throws Exception {

		Connection conn = DbUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from contacts");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String city = rs.getString("city");
			System.out.printf("%d - %s (%s)\n", id, name, city);
		}

		rs.close();
		stmt.close();
		conn.close();

	}
}
