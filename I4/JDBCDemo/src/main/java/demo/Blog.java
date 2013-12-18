package demo;

import dao.CustomerDao;

public class Blog {

	private DbHelper helper;
	
	private CustomerDao dao;

	public void doSomething() {
		// DBHelper
		System.out.println("Using helper...");
		helper.saveUser("a", "b");
		
		// DAO
		System.out.println("Using DAO...");
		dao.saveUser("c", "d");
	}

	public void setHelper(DbHelper helper) {
		this.helper = helper;
	}

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

}
