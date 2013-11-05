package de.tum.dss;

public class Main {

	public Main()
	{
		// Create a new instance of blog
		Blog blog = new Blog();
		
		// Find posts in this blog
		blog.findPostsWith("test"); 
	}
	
	public static void main(String arg[])
	{
		new Main(); 
	}
}
