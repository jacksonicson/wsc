package demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


public class SimpleJDBC {

	public SimpleJDBC() {

		Connection connection = null;
		try {
			// /////////////////////////////////////////////////
			// Loading the JDBC driver (MySQL)
			// (Not necessary if the driver is a service)
			Class.forName("com.mysql.jdbc.Driver");
			// /////////////////////////////////////////////////

			// /////////////////////////////////////////////////
			// Creating a new connection to the database
			// /////////////////////////////////////////////////
			System.out.println("Creating a Connection");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerDb",
					"root", "root");

			Statement statement = connection.createStatement();

			// /////////////////////////////////////////////////
			// A simple query
			// /////////////////////////////////////////////////
			System.out.println("Simple Queries");
			ResultSet set = statement.executeQuery("select * from customers");
			while (set.next()) {
				System.out.println("DB row fetched");
				int id = set.getInt(1);
				String forename = set.getString("forename");
				String surname = set.getString(3);
				System.out.println("Data: " + id + ":" + forename + ":" + surname);
			}

			// /////////////////////////////////////////////////
			// A simple update statement
			// /////////////////////////////////////////////////
			System.out.println("Simple Updates");
			int num = statement
					.executeUpdate("insert into customers (forename, surname) values ('a', 'b');");
			System.out.println("Number of modified rows: " + num);

			// /////////////////////////////////////////////////
			// Generated keys (ID)
			// /////////////////////////////////////////////////
			System.out.println("Generated Keys");
			num = statement.executeUpdate(
					"insert into customers (forename, surname) values ('a', 'b');",
					Statement.RETURN_GENERATED_KEYS);
			System.out.println("Number of modified rows: " + num);
			ResultSet keys = statement.getGeneratedKeys();
			while (keys.next()) {
				System.out.println("Generated Key: " + keys.getInt(1));
			}

			// /////////////////////////////////////////////////
			// Prepared Statements
			// /////////////////////////////////////////////////
			System.out.println("Prepared Statements");
			PreparedStatement prepStatement = connection.prepareStatement(
					"insert into customers (forename, surname) values (?,?)",
					Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, "prepared");
			prepStatement.setString(2, "statement");
			num = prepStatement.executeUpdate();
			System.out.println("Number of modified rows: " + num);
			keys = prepStatement.getGeneratedKeys();
			while (keys.next()) {
				System.out.println("Generated Key: " + keys.getInt(1));
			}

			// /////////////////////////////////////////////////
			// Prepared Statements Batch
			// /////////////////////////////////////////////////
			System.out.println("Prepared Statement Batch");
			PreparedStatement prepBatch = connection.prepareStatement(
					"insert into customers (forename, surname) values (?,?)",
					Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < 10; i++) {
				prepBatch.setString(1, "prepared" + i);
				prepBatch.setString(2, "statement" + i);
				prepBatch.addBatch();
			}

			int[] nums = prepBatch.executeBatch();
			System.out.println("Number of modified rows: " + nums.length);
			keys = prepBatch.getGeneratedKeys();
			while (keys.next()) {
				System.out.println("Generated Key: " + keys.getInt(1));
			}

			// /////////////////////////////////////////////////
			// SQL Injection
			// /////////////////////////////////////////////////
			String userInput = "blub' where id = 11; # ";
			String query = "update names set name = '" + userInput + "' where id = 10";
			System.out.println("Query: " + query);

			// /////////////////////////////////////////////////
			// Transactions
			// /////////////////////////////////////////////////
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			// Do statements here
			// Do a rollback
			connection.rollback();
			// Commit all changes
			connection.commit();

			// /////////////////////////////////////////////////
			// Support for Savepoints
			// /////////////////////////////////////////////////
			DatabaseMetaData meta = connection.getMetaData();
			System.out.println("Supports savepoints: " + meta.supportsSavepoints());

			// /////////////////////////////////////////////////
			// Savepoints
			// /////////////////////////////////////////////////
			Savepoint sav = connection.setSavepoint();

			// Update savepoint ...

			// Rollback all changes until a specific savepoint
			connection.rollback(sav);

			// Lots of checked exceptions
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close connection
			if (connection != null)
				try {
					if (!connection.isClosed())
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	public static void main(String arg[]) {
		new SimpleJDBC();
	}
}
