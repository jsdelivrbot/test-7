package com.scjn.gitlabauthapp.domain.model.gitlab.data;

public class MilestoneData {
	private String id;
	private String iid;
	private String project_id;
	private String title;
	private String description;
	private String state;
	private String created_at;
	private String updated_at;
	private String due_date;
	private String start_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

}
/*
 * 
    "milestone": {
      "id": 65,
      "iid": 1,
      "project_id": 109,
      "title": "abc",
      "description": "prueba millestona[kubermnates-centos.pdf](/uploads/9ef26f42a27fd34b71e6dd50b0264f37/kubermnates-centos.pdf)\r\n\r\n1.  test\r\n1.  tes\r\n1.  qaaa\r\n* [ ]  ",
      "state": "active",
      "created_at": "2017-03-30T16:52:01.856Z",
      "updated_at": "2017-03-30T16:52:01.856Z",
      "due_date": "2017-03-13",
      "start_date": "2017-03-07"
    },
    
*/
