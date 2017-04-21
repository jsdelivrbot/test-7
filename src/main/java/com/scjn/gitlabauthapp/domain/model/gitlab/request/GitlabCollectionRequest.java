package com.scjn.gitlabauthapp.domain.model.gitlab.request;

public class GitlabCollectionRequest {
	private String token;
	private int page;
	private int items;
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	
}
