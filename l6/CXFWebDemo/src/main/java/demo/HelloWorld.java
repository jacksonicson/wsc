package demo;

import javax.jws.WebService;


@WebService
public interface HelloWorld {
	
    String sayHello(String msg);
    
}

