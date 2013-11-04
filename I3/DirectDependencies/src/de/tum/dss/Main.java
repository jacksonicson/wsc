package de.tum.dss;

public class Main {

	public Main()
	{
		Blog blog = new Blog(); 
		blog.findPostsWith("test"); 
	}
	
	public static void main(String arg[])
	{
		new Main(); 
	}
}
