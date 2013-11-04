package de.ibis.tum;

public class TestModel {

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void logic() {
		System.out.println("running test model logic");
		this.value++;
	}

}
