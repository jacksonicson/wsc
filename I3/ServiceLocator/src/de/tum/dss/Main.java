package de.tum.dss;

import de.tum.dss.beans.Dictionary;
import de.tum.dss.beans.TextSearch2;
import de.tum.dss.exceptions.InvalidServiceRegistrationException;
import de.tum.dss.locator.ServiceLocator;

public class Main {

	public Main() {
		// Get an instance of the service locator
		ServiceLocator locator = ServiceLocator.getServiceLocator();
		try {
			// Register beans
			locator.registerService("dictionary", new Dictionary());
			locator.registerService("textSearch", new TextSearch2());
		} catch (InvalidServiceRegistrationException e) {
			e.printStackTrace();
		}

		// Create a new instance of blog
		Blog blog = new Blog();
		blog.findPostsWith("test");
	}

	public static void main(String arg[]) {
		new Main();
	}
}
