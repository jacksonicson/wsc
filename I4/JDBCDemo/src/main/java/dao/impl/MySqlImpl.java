package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import dao.UserTransferable;

public class MySqlImpl implements CustomerDao {

	private Connection connection;

	public MySqlImpl() throws ClassNotFoundException, SQLException {
		createConnection();
	}

	private void createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerDb", "root",
				"root");
	}

	private synchronized void checkConnection() {
		try {
			if (connection.isClosed())
				createConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public synchronized void saveUser(String forename, String surname) {
		checkConnection(); 
		try {
			PreparedStatement stat = connection
					.prepareStatement("insert into customers (forename, surname) values (?,?)");
			stat.setString(1, forename);
			stat.setString(2, surname);

			stat.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public synchronized UserTransferable getUser(int id) {
		checkConnection();
		try {
			PreparedStatement stat = connection
					.prepareStatement("select * from customers where id = ?");
			stat.setInt(1, id);
			ResultSet set = stat.executeQuery();
			List<UserTransferable> users = new ArrayList<UserTransferable>();
			while (set.next()) {
				String forename = set.getString(2);
				String surname = set.getString(3);
				UserTransferable user = new UserTransferable(forename, surname);
				users.add(user);
			}

			return users.get(0);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
