package de.tum.dss;

import java.util.List;

import de.tum.dss.beans.IDictionary;
import de.tum.dss.beans.ITextSearch;
import de.tum.dss.locator.ServiceLocator;

public class Blog {

	// Interface
	private IDictionary dictionary;

	// Interface
	private ITextSearch textSearch;

	public Blog() {
		System.out.println("new Blog");

		// Use the service locator to resolve dependencies
		dictionary = (IDictionary) ServiceLocator.getServiceLocator().lookup(
				"dictionary");
		textSearch = (ITextSearch) ServiceLocator.getServiceLocator().lookup(
				"textSearch");
		
		// Configure beans
		dictionary.setLanguage("de");
	}

	public List<Post> findPostsWith(String keyword) {
		System.out.println("findPostWith: " + keyword + " .. not implemented");
		textSearch.find("some text", keyword);
		return null;
	}

	public void lookup(String keyword) {
		dictionary.lookup(keyword);
	}
}
