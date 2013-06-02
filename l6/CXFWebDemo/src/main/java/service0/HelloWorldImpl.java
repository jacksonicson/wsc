package service0;

import javax.jws.WebService;

import beans.Test;

@WebService(endpointInterface = "service0.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String sayHello(String text) {
		System.out.println("Client says: " + text);
		return "Hello World"; 
	}

	public void setTest(Test test) {
		System.out.println("HelloWorld service injection of test");
	}

}
