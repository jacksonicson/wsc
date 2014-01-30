package demo;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import de.tum.in.dss.world.IHelloWorld;

public class HelloWorldClient {
	public static void main(String args[]) {
		// JAX-WS factory
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(IHelloWorld.class);
		factory.setAddress("http://localhost:9000/helloWorld");

		// New client
		IHelloWorld client = (IHelloWorld) factory.create();
		for (int i = 0; i < 100; i++)
			client.sayHello(i);
	}

}
