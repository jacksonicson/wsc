package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import dao.CustomerDao;
import dao.UserTransferable;

public class SpringDao implements CustomerDao {

	SimpleJdbcTemplate template;

	private PlatformTransactionManager transactionManager;

	public void saveUser(String forename, String surname) {
		template.update(
				"insert into customers (forename, surname) values (?,?);",
				forename, surname);
	}

	public void saveUserTransaction(final String forename, final String surname) {

		TransactionTemplate templ = new TransactionTemplate(transactionManager);
		templ.execute(new TransactionCallback() {

			public Object doInTransaction(TransactionStatus status) {
				template.update(
						"insert into customers (forename, surname) values (?,?);",
						forename, surname);
				return null;
			}

		});
	}

	public UserTransferable getUser(int id) {
		ParameterizedRowMapper<UserTransferable> mapper = new ParameterizedRowMapper<UserTransferable>() {

			public UserTransferable mapRow(ResultSet rs, int rowNum) throws SQLException {
				String forename = rs.getString(2);
				String surname = rs.getString(3);
				return new UserTransferable(forename, surname);
			}
		};

		List<UserTransferable> names = template.query("select * from customers", mapper);
		return names.get(0);
	}

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void setDataSource(DriverManagerDataSource ds) {
		this.template = new SimpleJdbcTemplate(ds);
	}
}
