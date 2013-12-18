package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelper {

	private Connection connection;

	enum Storage {
		DATABASE, XML
	}

	private Storage currentStorage = Storage.XML;

	public DbHelper() throws ClassNotFoundException, SQLException {
		createConnection();
	}
	
	public DbHelper(Storage storage) throws ClassNotFoundException, SQLException {
		this.currentStorage = storage;
		createConnection();
	}

	private void createConnection() throws ClassNotFoundException, SQLException {
		switch (currentStorage) {
		case DATABASE:
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerDb",
					"root", "root");
			break;
		case XML:
			break;
		}
	}

	protected synchronized void saveUser(String forename, String surname) {
		switch (currentStorage) {
		case DATABASE:
			saveUserDatabase(forename, surname);
			break;
		case XML:
			saveUserXML(forename, surname);
			break;
		}

	}

	private void saveUserXML(String forename, String surname) {
		// Implementation goes here
	}

	private void saveUserDatabase(String forename, String surname) {
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
}
