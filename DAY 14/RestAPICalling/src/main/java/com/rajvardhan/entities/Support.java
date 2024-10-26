package com.rajvardhan.entities;

public class Support {
	private String url;
	private String text;

	public Support() {
	}

	public Support(String url, String text) {
		this.url = url;
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public String getText() {
		return text;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setText(String text) {
		this.text = text;
	}

	void Display() {
		System.out.println("URL  ::"+url);
		System.out.println("Text ::"+text);
	}
}
