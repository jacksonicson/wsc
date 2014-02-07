

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbTest {

	private Connection connection;

	private void createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fim", "root", "root");
	}

	private void checkConnection() {
		try {
			if (connection.isClosed())
				createConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		try {
			if (!connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void loadUsers() {
		checkConnection();
		try {
			String statement = "select * from user left join address on user.id = address.userid";
			Statement stat = connection.createStatement();
			ResultSet result = stat.executeQuery(statement);
			while (result.next()) {
				System.out.println("Row: ");

				// we know we've 11 columns
				for (int i = 1; i < 12; i++) {
					System.out.println(" - " + result.getObject(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void loadUsersPrepared() {
		checkConnection();
		try {
			String statement = "select * from user left join address on user.id = address.userid where user.id = ?";
			PreparedStatement stat = connection.prepareStatement(statement);
			stat.setInt(1, 7);

			ResultSet result = stat.executeQuery();
			while (result.next()) {
				System.out.println("Row: ");

				// we know we've 11 columns
				for (int i = 1; i < 12; i++) {
					System.out.println(" - " + result.getObject(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createUsers() {
		checkConnection();
		try {
			String statement = "insert into user (surname, lastname, age, birth) values (?, ?, ?, ?)";
			PreparedStatement statUser = connection.prepareStatement(statement, 1);

			statement = "insert into address (city, plz, street, housenumber, userid) value (?, ?, ?, ?, ?)";
			PreparedStatement statAddress = connection.prepareStatement(statement);

			connection.setAutoCommit(false);

			for (int i = 0; i < 99; i++) {
				statUser.setString(1, "james");
				statUser.setString(2, "brown");
				statUser.setInt(3, 32);
				statUser.setDate(4, new Date(System.currentTimeMillis()));

				int affected = statUser.executeUpdate();
				ResultSet genKeys = statUser.getGeneratedKeys();
				genKeys.next();
				int primaryKey = genKeys.getInt(1);

				statAddress.setString(1, "munic");
				statAddress.setString(2, "5555");
				statAddress.setString(3, "stree");
				statAddress.setInt(4, 3);
				statAddress.setInt(5, primaryKey);
				
				statAddress.executeUpdate();
			}

			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createUsersRollback() {
		checkConnection();
		try {
			String statement = "insert into user (surname, lastname, age, birth) values (?, ?, ?, ?)";
			PreparedStatement statUser = connection.prepareStatement(statement, 1);

			statement = "insert into address (city, plz, street, housenumber, userid) value (?, ?, ?, ?, ?)";
			PreparedStatement statAddress = connection.prepareStatement(statement);

			connection.setAutoCommit(false);

			for (int i = 0; i < 99; i++) {
				statUser.setString(1, "james");
				statUser.setString(2, "brown");
				statUser.setInt(3, 32);
				statUser.setDate(4, new Date(System.currentTimeMillis()));

				int affected = statUser.executeUpdate();
				ResultSet genKeys = statUser.getGeneratedKeys();
				genKeys.next();
				int primaryKey = genKeys.getInt(1);

				statAddress.setString(1, "munic");
				statAddress.setString(2, "5555");
				statAddress.setString(3, "stree");
				statAddress.setInt(4, 3);
				statAddress.setInt(5, primaryKey);

				statAddress.executeUpdate();

				throw new SQLException();
			}

			connection.commit();

		} catch (SQLException e) {
			// e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void removeAll() {
		checkConnection();
		try {
			String statement = "select user.id from user";
			Statement stat = connection.createStatement();
			ResultSet result = stat.executeQuery(statement);

			List<Integer> userIds = new ArrayList<Integer>();
			while (result.next()) {
				int idUser = result.getInt(1);
				userIds.add(idUser);
			}

			List<Integer> addressIds = new ArrayList<Integer>();
			for (Integer idUser : userIds) {
				statement = "select address.id from address where userid = " + idUser;
				ResultSet resultAddress = stat.executeQuery(statement);

				while (resultAddress.next()) {
					int idAddress = resultAddress.getInt(1);
					addressIds.add(idAddress);
				}
			}

			for (Integer idAddress : addressIds) {
				statement = "delete from address where id = " + idAddress;
				stat.executeUpdate(statement);
			}

			for (Integer idUser : userIds) {
				statement = "delete from user where id = " + idUser;
				stat.executeUpdate(statement);
			}

			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public DbTest() throws ClassNotFoundException, SQLException {
		createConnection();
		checkConnection();
		loadUsersPrepared();
		createUsers();
		removeAll();
		closeConnection();
	}

	public static void main(String arg[]) {
		try {
			new DbTest();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
