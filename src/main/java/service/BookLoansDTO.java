package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.BookLoans;
import util.DBConnection;

public class BookLoansDTO {
	
	ArrayList<BookLoans> bookLoans = new ArrayList<BookLoans>();
	
	public ArrayList<BookLoans> getBookLoans(){
		Connection connection = new DBConnection().getConnection();
		Statement statement = null;
		
		try {
			System.out.println("Creating statement for book loans...");
			statement = connection.createStatement();
			String sql;
			sql = "SELECT * FROM tbl_book_loans";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				BookLoans bookLoan = new BookLoans();
				bookLoan.setBookId(rs.getInt("bookId"));
				bookLoan.setBranchId(rs.getInt("branchid"));
				bookLoan.setCardNo(rs.getInt("cardNo"));
				bookLoan.setDateOut(rs.getDate("dateOut"));
				bookLoan.setDueDate(rs.getDate("dueDate"));
				bookLoans.add(bookLoan);
			}
			rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				statement.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}	
		return bookLoans;	
	}

}
