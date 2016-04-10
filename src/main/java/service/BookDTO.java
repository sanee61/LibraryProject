package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Author;
import model.Book;
import util.DBConnection;

public class BookDTO {
	
	ArrayList<Book> books = new ArrayList<Book>();
	public ArrayList<Book> getBooks(){
		
		Connection connection = new DBConnection().getConnection();
		Statement statement = null;
		try{
			System.out.println("Creating statement for book...");
			statement = connection.createStatement();
			String sql;
			sql = "SELECT * FROM tbl_book inner join tbl_author on tbl_author.authorId=tbl_book.authId";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Book book = new Book();
				Author author = new Author();
				book.setBookId(rs.getInt("bookId"));
				author.setAuthorId(rs.getInt("authId"));
				author.setAuthorName(rs.getString("authorName"));
                book.setAuthor(author);
				book.setTitle(rs.getString("title"));
				book.setPubId(rs.getInt("pubId"));
				books.add(book);			
			}
			rs.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
			
		return books;
		
	}

}
