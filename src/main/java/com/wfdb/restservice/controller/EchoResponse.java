package com.wfdb.restservice.controller;

public class EchoResponse {

	private long count;
	private String content;

	public EchoResponse(long count, String content) {
		super();
		this.count = count;
		this.content = content;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
