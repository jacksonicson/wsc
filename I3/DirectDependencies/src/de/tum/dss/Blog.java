package de.tum.dss;

import java.util.ArrayList;
import java.util.List;

import de.tum.dss.services.Dictionary;
import de.tum.dss.services.TextSearch;

public class Blog {

	// Hard-wired dependency
	private Dictionary dictionary;

	// Hard-wired dependency
	private TextSearch textSearch;

	// List of posts in this blog
	private List<Post> posts = new ArrayList<Post>();

	public Blog() {
		System.out.println("created a new instance of Blog");

		// Create dictionary instance
		dictionary = new Dictionary();
		dictionary.setLanguage("de");

		// Create text search instance
		textSearch = new TextSearch();

		for (int i = 0; i < 10; i++)
			posts.add(new Post());
	}

	public List<Post> findPostsWith(String keyword) {
		System.out.println("findPostWith: " + keyword);
		List<Post> result = new ArrayList<Post>();
		for (Post post : posts)
			if (textSearch.find(post.getContent(), keyword))
				result.add(post);
		return result;
	}

	public void lookup(String keyword) {
		dictionary.lookup(keyword);
	}
}
