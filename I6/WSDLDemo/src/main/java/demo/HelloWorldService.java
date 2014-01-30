package demo;

import javax.xml.ws.Endpoint;

public class HelloWorldService {

	protected HelloWorldService() throws Exception {
		System.out.println("starting server...");

		// Service implementation
		HelloWorldImpl implementor = new HelloWorldImpl();

		// Address to publish the service
		String address = "http://localhost:9000/helloWorld";

		// Publish service and wait for requests
		Endpoint.publish(address, implementor);

		// Test
		// http://localhost:9000/helloWorld/sayHello?value=3
	}

	public static void main(String args[]) throws Exception {
		new HelloWorldService();
	}
}
