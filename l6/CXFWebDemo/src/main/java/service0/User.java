package service0;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user", namespace = "http://dss.in.tum.de/user")
public class User {

	private String surename;

	private String lastname;

	private int age;

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
