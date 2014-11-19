package com.service.me;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.entity.me.ParkData;

public class myPaser {

	MySQLDBUtil util = new MySQLDBUtil();
	Connection connection = util.getConnection();
	String sql;
	private final String TABLE_NAME = "parkData";

	public void add(ParkData gh) {
		sql = "insert into " + TABLE_NAME + "(address,status) values (?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, gh.getAddress());
			pstmt.setString(2, gh.getStatus());

			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(ParkData gh) {
		sql = "update " + TABLE_NAME + " set status = ? where address = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, gh.getStatus());
			pstmt.setString(2, gh.getAddress());

			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean checkUserExistsWithName(String gwName) {
		int count = 0;
		sql = "select count(*) from " + TABLE_NAME + " where address = " + "'"
				+ gwName + "'";

		try {
			if (connection == null)
				connection = util.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			resultSet.next();
			count = resultSet.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count > 0) {
			return true;
		}
		return false;
	}

	public void closeConnection() {
		util.closeConnection(connection);
	}

}
