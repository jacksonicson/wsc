package de.tum.dss.locator;

import java.util.HashMap;
import java.util.Map;

import de.tum.dss.exceptions.InvalidServiceRegistrationException;

public class ServiceLocator {

	private static ServiceLocator singleton;

	// Mapping of service names to service objects
	private Map<String, Object> services = new HashMap<String, Object>();

	public static ServiceLocator getServiceLocator() {
		if (ServiceLocator.singleton == null) {
			ServiceLocator.singleton = new ServiceLocator();
		}

		return ServiceLocator.singleton;
	}

	public void registerService(String id, Object o)
			throws InvalidServiceRegistrationException {
		if (id == null || o == null)
			throw new InvalidServiceRegistrationException();
		System.out.println("ServiceLocator registerService");
		this.services.put(id, o);
	}

	public Object lookup(String id) {
		System.out.println("ServiceLocator lookup: " + id);
		return services.get(id);
	}
}
