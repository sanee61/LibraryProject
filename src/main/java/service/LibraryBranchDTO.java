package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.LibraryBranch;
import util.DBConnection;

public class LibraryBranchDTO {
	
	ArrayList<LibraryBranch> libraryBranches = new ArrayList<LibraryBranch>();

	public ArrayList<LibraryBranch> getBranches() {
		
		Connection connection = new DBConnection().getConnection();
		Statement statement = null;
		
		try {
			System.out.println("Creating statement for library branch...");
			statement = connection.createStatement();
			String sql;
			sql = "SELECT * FROM tbl_library_branch";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				LibraryBranch libraryBranch = new LibraryBranch();
				libraryBranch.setBranchId(rs.getInt("branchId"));
				libraryBranch.setBranchName(rs.getString("branchName"));
				libraryBranch.setBranchAddress(rs.getString("branchAddress"));
				libraryBranches.add(libraryBranch);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				statement.close();				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return libraryBranches;		
	}
}
