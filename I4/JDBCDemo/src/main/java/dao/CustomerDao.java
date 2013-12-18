package dao;


public interface CustomerDao {

	void saveUser(String forename, String surname);
	
	UserTransferable getUser(int id); 
}
