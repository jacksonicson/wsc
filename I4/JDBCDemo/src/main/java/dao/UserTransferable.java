package dao;

// A simple transferable object
public class UserTransferable {

	private final String forename;
	private final String surname;

	public UserTransferable(String forename, String surname) {
		this.forename = forename;
		this.surname = surname;
	}

	public String getForename() {
		return forename;
	}

	public String getSurname() {
		return surname;
	}
}
