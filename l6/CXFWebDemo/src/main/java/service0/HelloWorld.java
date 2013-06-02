package service0;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	String sayHello(String text);
}
