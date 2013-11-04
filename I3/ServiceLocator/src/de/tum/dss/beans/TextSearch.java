package de.tum.dss.beans;

public class TextSearch implements ITextSearch {

	public TextSearch() {
		System.out.println("new TextSearch");
	}

	public boolean find(String text, String keyword) {
		System.out.println("TextSearch1 find");
		return true;
	}

}
