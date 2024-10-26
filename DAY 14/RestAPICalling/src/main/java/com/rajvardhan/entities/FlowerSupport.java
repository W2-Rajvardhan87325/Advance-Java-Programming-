package com.rajvardhan.entities;

public class FlowerSupport {

	private Flower data;
	private Support support;

	public FlowerSupport() {
	}

	public FlowerSupport(Flower data, Support support) {
		this.data = data;
		this.support = support;
	}

	public Flower getData() {
		return data;
	}

	public Support getSupport() {
		return support;
	}

	public void setData(Flower data) {
		this.data = data;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	void Display() {
		data.Display();
		support.Display();
	}

}
