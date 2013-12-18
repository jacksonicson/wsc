package dao.impl;

import dao.CustomerDao;
import dao.UserTransferable;

public class XmlImpl implements CustomerDao {

	public void saveUser(String forename, String surname) {
		System.out.println("Dummy saving user");
	}

	public UserTransferable getUser(int id) {
		System.out.println("Dummy getting user");
		return null;
	}
}
