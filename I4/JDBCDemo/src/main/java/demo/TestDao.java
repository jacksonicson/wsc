package demo;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CustomerDao;
import dao.impl.SpringDao;

public class TestDao {

	public TestDao() {
		spring();
	}

	private void spring() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		BeanFactory factory = context;
		
		// Load Blog bean which accesses the DAO implementations
		Blog blog = (Blog) factory.getBean("Blog");
		blog.doSomething();
	}

	public static void main(String arg[]) {
		new TestDao();
	}
}
