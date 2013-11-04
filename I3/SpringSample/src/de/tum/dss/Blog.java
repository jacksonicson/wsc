package de.tum.dss;

import java.util.Collections;
import java.util.List;

import de.tum.dss.beans.IDictionary;
import de.tum.dss.beans.ITextSearch;

public class Blog {

	// Dependencies - only interfaces
	private IDictionary dictionary;
	private ITextSearch textSearch;

	public Blog() {
		System.out.println("new Blog");
	}

	@SuppressWarnings("unchecked")
	public List<Post> findPostsWith(String keyword) {
		textSearch.find("blablabla", keyword);
		return (List<Post>)Collections.EMPTY_LIST; 
	}

	public void lookup(String keyword) {
		dictionary.lookup(keyword);
	}

	public void setDictionary(IDictionary dictionary) {
		System.out.println("Injecting directory"); 
		this.dictionary = dictionary;
	}

	public void setTextSearch(ITextSearch textSearch) {
		System.out.println("Injecting textSearch");
		this.textSearch = textSearch;
	}
}
