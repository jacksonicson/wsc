package de.tum.dss;

import java.util.ArrayList;
import java.util.List;

public class Blog {

	private Dictionary dictionary;

	private TextSearch textSearch;

	private List<Post> posts = new ArrayList<Post>();

	public Blog() {
		System.out.println("new Blog");

		dictionary = new Dictionary();
		dictionary.setLanguage("de");

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
