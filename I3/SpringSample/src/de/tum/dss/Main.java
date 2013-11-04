package de.tum.dss;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {

	public Main() {

		// Initialize the spring container with a configuration file
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"/etc/spring.xml", getClass()));

		// Get object from ontainer
		Blog blog = (Blog) factory.getBean("blog");
		blog.findPostsWith("test");
	}

	public static void main(String arg[]) {
		new Main();
	}
}
