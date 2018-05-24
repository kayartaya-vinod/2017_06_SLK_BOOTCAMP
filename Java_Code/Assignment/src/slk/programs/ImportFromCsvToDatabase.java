package slk.programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import slk.util.DbUtil;

public class ImportFromCsvToDatabase {

	public static void main(String[] args) throws Exception {

		// read the csv file line by line
		String filename = "/Users/vinodkumar/Desktop/contacts.csv";
		FileReader file = new FileReader(filename);
		BufferedReader in = new BufferedReader(file);

		String line = in.readLine();
		
		List<String> errors = new ArrayList<>();

		Connection conn = DbUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into contacts values(?,?,?,?,?,?)");
		int count = 0;
		
		while ((line = in.readLine()) != null) {
			// split the line
			String[] vals = line.split(",");
			for (int i = 0; i < vals.length; i++) {
				stmt.setString(i + 1, vals[i]);
			}
			
			try {
				// insert to table
				stmt.executeUpdate();
				count++;
			} catch (Exception e) {
				errors.add(line);
			}
		}
		
		stmt.close();
		conn.close();
		
		in.close();
		file.close();
		
		System.out.println("Total " + count + " rows inserted!");
		if(errors.size()>0){
			System.out.println("These rows could not be inserted!");
			for(String row: errors){
				System.out.println(row);
			}
		}

	}
}
