package com.rupp.evening.assign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

import com.rupp.evening.assign.DBConnection;

public class Customer {
	private int id;
	private String lname, fname, sex, email, phone, address;
	private Date dob;
	private java.sql.Date sqlDate;
	private static DBConnection db = new DBConnection();

	Customer() {

	};

	Customer(int id, String fname, String lname, String sex, String email, Date dob, String phone,
			String address) {
		this.id = id;
		this.lname = lname;
		this.fname = fname;
		this.sex = sex;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.sqlDate = new java.sql.Date(dob.getTime());
	}

	public static List<Customer> getAllCustomer() {
		String sql;
		List<Customer> rows = new ArrayList<Customer>();
		try {
			sql = "SELECT * FROM tb_customer";
			ResultSet rs = db.getStatement().executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("cus_id");
				String lname = rs.getString("cus_last_name");
				String fname = rs.getString("cus_first_name");
				String sex = rs.getString("cus_sex");
				String email = rs.getString("cus_email_address");
				Date dob = rs.getDate("cus_dob");
				String phone = rs.getString("cus_phone_number");
				String address = rs.getString("cus_address");
				Customer customer = new Customer(id, fname, lname, sex, email, dob, phone, address);
				rows.add(customer);
			}

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// db.closeConnection();
		}
		return rows;
	}

	public static Customer getCustomer(int cus_id) {
		String sql;
		Customer cus = null;
		try {
			sql = "SELECT * FROM tb_customer where cus_id=" + cus_id;
			ResultSet rs = db.getStatement().executeQuery(sql);
			rs.first();
			int id = rs.getInt("cus_id");
			String lname = rs.getString("cus_last_name");
			String fname = rs.getString("cus_first_name");
			String sex = rs.getString("cus_sex");
			String email = rs.getString("cus_email_address");
			Date dob = rs.getDate("cus_dob");
			String phone = rs.getString("cus_phone_number");
			String address = rs.getString("cus_address");
			cus = new Customer(id, fname, lname, sex, email, dob, phone, address);

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// db.closeConnection();
		}
		return cus;
	}

	public void addCustomer() {
		String sql = "INSERT INTO `tb_customer` (`cus_first_name`, `cus_last_name`, `cus_sex`, `cus_email_address`, `cus_dob`, `cus_address`, `cus_phone_number`) "
				+ "VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement prestmt = db.getPrepareStatement(sql);
			prestmt.setString(1, fname);
			prestmt.setString(2, lname);
			prestmt.setString(3, sex);
			prestmt.setString(4, email);
			prestmt.setDate(5, sqlDate);
			prestmt.setString(6, address);
			prestmt.setString(7, phone);
			prestmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateCustomer() {

		// Format formatter = new SimpleDateFormat("yyyy-mm-dd");
		// String dob = formatter.format(this.dob);
		String sql = "UPDATE tb_customer SET cus_first_name=?,cus_last_name=?"
				+ ",cus_sex=?,cus_email_address=?,cus_dob=?" + ",cus_address=?,cus_phone_number=?"
				+ " where cus_id=?";

		PreparedStatement prestmt = db.getPrepareStatement(sql);
		try {
			prestmt.setString(1, fname);
			prestmt.setString(2, lname);
			prestmt.setString(3, sex);
			prestmt.setString(4, email);
			prestmt.setDate(5, sqlDate);
			prestmt.setString(6, address);
			prestmt.setString(7, phone);
			prestmt.setInt(8, id);
			prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// db.closeConnection();
		}

	}

	public void deleteCustomer(int id) {
		DBConnection db = new DBConnection();
		String sql = "DELETE FROM tb_customer where cus_id=?";
		try {
			PreparedStatement prestmt = db.getPrepareStatement(sql);
			prestmt.setInt(1, id);
			prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.closeConnection();
	}

	public int getID() {
		return this.id;
	}

	public String getFName() {
		return this.fname;
	}

	public String getLname() {
		return this.lname;
	}

	public String getSex() {
		return this.sex;
	}

	public String getEmail() {
		return this.email;
	}

	public Date getDOB() {
		return this.dob;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddress() {
		return this.address;
	}
}
