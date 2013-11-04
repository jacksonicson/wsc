package de.tum.dss.beans;

public class Dictionary implements IDictionary {

	public Dictionary() {
		System.out.println("new Dictionary");
	}

	public void setLanguage(String lang) {
		System.out.println("Dictionary setLanguage");
	}

	public void lookup(String keyword) {
		System.out.println("Dictionary lookup");
	}

}
