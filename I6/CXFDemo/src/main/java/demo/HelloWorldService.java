package demo;

import javax.xml.ws.Endpoint;

public class HelloWorldService {

	protected HelloWorldService() throws Exception {
		System.out.println("starting server...");
		
		// Service implementation
		HelloWorldImpl implementor = new HelloWorldImpl();
		
		// Address to publish the service
		String address = "http://localhost:9000/helloWorld";
		
		// Publish service and wait for requests (starts jetty server)
		Endpoint.publish(address, implementor);
	}

	public static void main(String args[]) throws Exception {
		new HelloWorldService();
	}
}
