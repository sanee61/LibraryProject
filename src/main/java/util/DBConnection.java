package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/library";

	static final String User = "root";
	static final String Password = "1234";

	private Connection connection;
	
	public Connection getConnection() {
		return createConnection();
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection createConnection(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection to database..");
			connection = DriverManager.getConnection(DB_URL, User, Password);
		} catch (ClassNotFoundException e){ 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return connection;
	}
}
