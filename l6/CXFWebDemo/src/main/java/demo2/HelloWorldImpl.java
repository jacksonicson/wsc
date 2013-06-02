package demo2;

import de.tum.in.dss.world.IHelloWorldImpl;

public class HelloWorldImpl extends IHelloWorldImpl {

	@Override
	public void sayHello(int value) {
		System.out.println("say hello was called");
	}

}
