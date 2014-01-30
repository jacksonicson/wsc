package ibis.in.tum.de;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

// Attributes of this class are not serialized by default
@XmlAccessorType(XmlAccessType.NONE)

// Use a root element with the name user and the namespace ...
@XmlRootElement(name = "user", namespace = "http://dss.in.tum.de")

// This is an XML type
@XmlType(name = "user")
public class User {

	@XmlAttribute(name="ID", required=true)
	private long id; 
	
	@XmlElement
	private String username;

	@XmlElement
	private String password;

	@XmlElement
	private String singature;

	@XmlElement
	private int age;

	@XmlElementWrapper(name = "hobbyList")
	@XmlElement(name = "book")
	private ArrayList<String> hobbies = new ArrayList<String>();

	@XmlElement
	@XmlList
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSingature() {
		return singature;
	}

	public void setSingature(String singature) {
		this.singature = singature;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
}
