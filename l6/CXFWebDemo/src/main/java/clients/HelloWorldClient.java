package clients;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import service0.HelloWorld;

public class HelloWorldClient {
	public static void main(String args[]) {
		// Create a new proxy factory
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloWorld.class);
		factory.setAddress("http://localhost:8080/wsc-0.0.1-SNAPSHOT/services/service0");

		// Createa a new proxy object
		HelloWorld client = (HelloWorld) factory.create();

		// Work with the proxy object
		String output = client.sayHello("hello world");
		System.out.println(output); 
	}

}
