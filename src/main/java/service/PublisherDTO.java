package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Publisher;
import util.DBConnection;

public class PublisherDTO {
	
	ArrayList<Publisher> publishers = new ArrayList<Publisher>();
	
	public ArrayList<Publisher> getPublishers(){
		
		Connection connection = new DBConnection().getConnection();
		Statement statement = null;
		
		try {
			System.out.println("Creating statement for publisher...");
			statement = connection.createStatement();
			String sql;
			sql = "SELECT * FROM tbl_publisher";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				Publisher publisher = new Publisher();
				publisher.setPubliserId(rs.getInt("publisherId"));
				publisher.setPublisherName(rs.getString("publisherName"));
				publisher.setPublisherAddress(rs.getString("publisherAddress"));
				publisher.setPublisherPhone(rs.getString("publisherPhone"));
				publishers.add(publisher);
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
		return publishers;
			
	}
}
