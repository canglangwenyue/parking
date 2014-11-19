package com.daoimpl.me;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.me.dataDealDao;
import com.entity.me.ParkData;
import com.service.me.MySQLDBUtil;

public class dataDealDaoImpl implements dataDealDao {

	MySQLDBUtil util = new MySQLDBUtil();
	Connection connection = util.getConnection();
	String sql;
	private final String TABLE_NAME = "parkData";
	private static dataDealDaoImpl dao = new dataDealDaoImpl();

	public static dataDealDaoImpl getInstance() {
		return dao;
	}

	public dataDealDaoImpl() {
	}

	@Override
	public void add(ParkData gh) {
		sql = "insert into " + TABLE_NAME + "(address,status) values (?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, gh.getAddress());
			pstmt.setString(2, gh.getStatus());

			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(connection);
		}

	}

	@Override
	public void update(ParkData gh) {
		sql = "update " + TABLE_NAME + " set status = ? where address = ?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, gh.getStatus());
			pstmt.setString(2, gh.getAddress());

			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(connection);
		}

	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		sql = "DELETE FROM `parking`.`parkData` WHERE `address`=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(connection);
		}
		return false;
	}

	@Override
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
		} finally {
			util.closeConnection(connection);
		}
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<ParkData> getParkList() {
		sql = "select * from " + TABLE_NAME;
		ParkData data = new ParkData();
		List<ParkData> list = new ArrayList<ParkData>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet reSet = pstmt.executeQuery();
			while (reSet.next()) {
				data.setAddress(reSet.getString(2));
				data.setStatus(reSet.getString(3));
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(connection);
		}

		return list;
	}

}