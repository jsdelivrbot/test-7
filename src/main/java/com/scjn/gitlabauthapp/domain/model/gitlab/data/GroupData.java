package com.scjn.gitlabauthapp.domain.model.gitlab.data;

public class GroupData {
	private String group_id;
	private String group_name;
	private String group_access_level;
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_access_level() {
		return group_access_level;
	}
	public void setGroup_access_level(String group_access_level) {
		this.group_access_level = group_access_level;
	}
	
	
	
/*
{
        "group_id": 22,
        "group_name": "DSJA",
        "group_access_level": 30
      }
      */
}
