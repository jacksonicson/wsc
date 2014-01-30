package demo;

import de.tum.in.dss.world.IHelloWorldImpl;

public class HelloWorldImpl extends IHelloWorldImpl {

	@Override
	public void sayHello(int value) {
		System.out.println("Server received from client: " + value);
	}
}
