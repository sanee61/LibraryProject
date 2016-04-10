package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Author;
import util.DBConnection;

public class AuthorDTO {
	// this is author DTO
	ArrayList<Author> authors = new ArrayList<Author>();
	
	public ArrayList<Author> getAuthors(){
		
		Connection connection = new DBConnection().getConnection();
		Statement statement = null;
	
		try{
			System.out.println("Creating statement for author...");
			statement = connection.createStatement();
			String sql;
			sql = "SELECT * FROM tbl_author";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Author author = new Author();
				author.setAuthorId(rs.getInt("authorId"));
				author.setAuthorName(rs.getString("authorName"));
				authors.add(author);
			}
			rs.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authors;		
	}
	public ResultSet getAuthorById(int authorId) {
		
		Connection connection = new DBConnection().getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{		
			preparedStatement = connection.prepareStatement("SELECT authorId, authorName FROM tbl_author WHERE authorId = ?");
			preparedStatement.setInt(1, authorId);
			resultSet = preparedStatement.executeQuery();
			resultSet.close();
		}
		catch (SQLException e){
		e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		return resultSet;
	}
}
