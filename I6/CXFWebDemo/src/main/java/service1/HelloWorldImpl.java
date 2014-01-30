package service1;

import beans.Test;
import de.tum.in.dss.world.IHelloWorldImpl;

public class HelloWorldImpl extends IHelloWorldImpl {

	@Override
	public void sayHello(int value) {
		System.out.println("say hello was called");
	}

	public void setTest(Test test) {
		System.out.println("HelloWorld service injection of test");
	}
	
}
