package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Borrower;
import util.DBConnection;

public class BorrowerDTO {
	
	ArrayList<Borrower> borrowers = new ArrayList<Borrower>();

	public ArrayList<Borrower> getBorrowers(){
		
		Connection connection = new DBConnection().getConnection();
		Statement statement = null;
		try {
			System.out.println("Creating statement for borrower...");
			statement = connection.createStatement();
			String sql;
			sql = "SELECT * FROM tbl_borrower";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Borrower borrower = new Borrower();
				borrower.setCardNo(rs.getInt("cardNo"));
				borrower.setName(rs.getString("name"));
				borrower.setAddress(rs.getString("address"));
				borrower.setPhone(rs.getString("phone"));
				borrowers.add(borrower);
			}
			rs.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				connection.close();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}	
		return borrowers;
		
	}
}
