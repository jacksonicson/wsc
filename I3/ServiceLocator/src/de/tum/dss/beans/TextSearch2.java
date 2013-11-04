package de.tum.dss.beans;

public class TextSearch2 implements ITextSearch {

	public TextSearch2() {
		System.out.println("new TextSearch2");
	}

	public boolean find(String text, String keyword) {
		System.out.println("TextSearch2 find");
		return true;
	}

}
