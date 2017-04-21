package com.scjn.gitlabauthapp.domain.model.gitlab.data;

public class PermissionData {
	private AccessData project_access;
	private AccessData group_access;
	
	public AccessData getProject_access() {
		return project_access;
	}
	public void setProject_access(AccessData project_access) {
		this.project_access = project_access;
	}
	public AccessData getGroup_access() {
		return group_access;
	}
	public void setGroup_access(AccessData group_access) {
		this.group_access = group_access;
	}
}
/*
    "permissions": {
    
	   	"project_access": {
	        "access_level": 40,
	        "notification_level": 3
	    },
      
	    "group_access": {
	        "access_level": 30,
	        "notification_level": 3
      	}
      	
	}
 * */
 