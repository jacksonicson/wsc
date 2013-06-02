package service0;

import javax.jws.WebService;

import beans.Test;

@WebService(endpointInterface = "service0.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String sayHello(String text) {
		System.out.println("Client says: " + text);
		return "Hello World";
	}

	public User getDemoUser() {
		User user = new User();
		user.setId(0);
		user.setSurename("Hello");
		user.setLastname("World");
		user.setAge(10000);
		user.addHobby("none");
		return user;
	}

	public void setTest(Test test) {
		System.out.println("HelloWorld service injection of test");
	}

}
