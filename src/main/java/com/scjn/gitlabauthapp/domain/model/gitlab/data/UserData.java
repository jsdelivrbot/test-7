package com.scjn.gitlabauthapp.domain.model.gitlab.data;

public class UserData {
	private String name;
	private String username;
	private String id;
	private String state;
	private String avatar_url;
	private String web_url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAvatar_url() {
		return avatar_url;
	}
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
}
/*
    "owner": {
      "name": "Luis Antonio Solís Cuevas",
      "username": "lasolisc",
      "id": 2,
      "state": "active",
      "avatar_url": "http://gitlab.scjn.pjf.gob.mx/uploads/user/avatar/2/IMG_0405.jpg",
      "web_url": "http://gitlab.scjn.pjf.gob.mx/lasolisc"
    },
    
 ****************************************************
      "name": "Alejandra Maqueda Policarpo",
      "username": "AMaquedaP",
      "id": 32,
      "state": "active",
      "avatar_url": "http://www.gravatar.com/avatar/5d988106eba63d7c5ad0e3f314d82c2a?s=80&d=identicon",
      "web_url": "http://gitlab.scjn.pjf.gob.mx/AMaquedaP" 
 * */
 