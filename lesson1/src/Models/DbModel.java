package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DbModel {
	static final String jdbc_driver = "com.mysql.jdbc.Driver";
	static final String db_url = "jdbc:mysql://localhost:3306/java-mvc";
	static final String db_user = "root";
	static final String db_pass = "";

	private Connection con;

	protected DbModel() throws ClassNotFoundException {
		try {
			Class.forName(jdbc_driver);
			con = DriverManager.getConnection(db_url, db_user, db_pass);
			System.out.println("database connected successfully.");
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database NOT connected!!!");
		}
	}

	protected ResultSet SelectQuery(String query) {
		ResultSet res = null;
		try {
			Statement stm = con.createStatement();
			res = stm.executeQuery(query);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "An error has occurred while connecting to database!!!");
		}
		return res;
	}

	protected void CrudQuery(String query, String action) {
		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, action +" query executed successfully.");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "An error has occurred!!!");
		}
	}
}
