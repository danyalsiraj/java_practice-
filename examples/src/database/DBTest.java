package database;

//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
////import sun.jdbc.odbc.JdbcOdbcDriver;

import java.sql.*;

public class DBTest {
	// private static Connection CONNECTION;// declare the instance variable
	public static Connection CONNECTION = null;// declare the instance variable
	public static Statement STATEMENT;

	public static void main(String[] args) {
		delete(1);

	}
	// jdbc:mysql://127.0.0.1:3306/?user=danyalsiraj
	// jdbc:mysql:// 127.0.0.1:3306/?user=danyalsiraj

	public static void connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "danyalsiraj",
					"Danyal_100");

			// Statement stmt = CONNECTION.createStatement();
			// ResultSet rs = stmt.executeQuery("select * from users");

			// while (rs.next())
			// System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
			// rs.getString(3) + " "
			// + rs.getString(4) + " " + rs.getString(5));
			// CONNECTION.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void save() {
		Statement stmt;
		connect();
		try {
			STATEMENT = CONNECTION.createStatement();
			int rs = STATEMENT
					.executeUpdate("insert into users (username,firstName,lastName) values('qqq','aaa','www')");
			CONNECTION.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void delete(int id) {
		connect();
		try {
			STATEMENT = CONNECTION.createStatement();
			int rs = STATEMENT.executeUpdate("delete from users where userid=" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
