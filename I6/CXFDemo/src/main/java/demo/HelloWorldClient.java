package demo;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class HelloWorldClient {
	public static void main(String args[]) {
		// Proxy factory
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloWorld.class);
		factory.setAddress("http://localhost:9000/helloWorld");
		
		// Create new proxy object
		HelloWorld client = (HelloWorld) factory.create();
		
		// Use proxy - which calls web client
		String reply = client.sayHello("hello world");
		System.out.println(reply);
	}

}
