package com.scjn.gitlabauthapp.domain.model.gitlab.data;

public class AccessData {
	private String access_level;
	private String notification_level;
	
	public String getAccess_level() {
		return access_level;
	}
	public void setAccess_level(String access_level) {
		this.access_level = access_level;
	}
	public String getNotification_level() {
		return notification_level;
	}
	public void setNotification_level(String notification_level) {
		this.notification_level = notification_level;
	}

}
/*
 	    {
	        "access_level": 30,
	        "notification_level": 3
      	}
      	
 * */
 