package com.service.me;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBUtil {

	// /**
	// * @author canglangwenyue
	// * @param args
	// * just for a test
	// */
	// public static void main(String[] args) {
	// MySQLDBUtil util = new MySQLDBUtil();
	// Connection connection = util.getConnection();
	// System.out.println(connection);
	// }

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/parking", "root", "bjx719519");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}

	public void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
