package demo;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class HelloWorldClient {
	public static void main(String args[]) {
		// Create a new proxy factory
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloWorld.class);
		factory.setAddress("http://localhost:8080/wsc/services/world");

		// Createa a new proxy object
		HelloWorld client = (HelloWorld) factory.create();

		// Work with the proxy object
		String reply = client.sayHello("hello world");
		System.out.println(reply);
	}

}
