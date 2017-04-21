package com.scjn.gitlabauthapp.domain.model.gitlab.response;

import java.io.Serializable;

import com.scjn.gitlabauthapp.domain.model.gitlab.data.MilestoneData;
import com.scjn.gitlabauthapp.domain.model.gitlab.data.UserData;

public class GitlabIssueResponse implements Serializable {
	private String id;
	private String iid;
	private String project_id;
	private String title;
	private String description;
	private String state;
	private String created_at;
	private String updated_at;
	private String[] labels;
	private MilestoneData milestone;
	private UserData assignee;
	private UserData author;
	private String user_notes_count;
	private String upvotes;
	private String downvotes;
	private String due_date;
	private String confidential;
	private String web_url;
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
	
	public String[] getLabels() {
		return labels;
	}
	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	
	public MilestoneData getMilestone() {
		return milestone;
	}
	public void setMilestone(MilestoneData milestone) {
		this.milestone = milestone;
	}
	public String getUser_notes_count() {
		return user_notes_count;
	}

	public void setUser_notes_count(String user_notes_count) {
		this.user_notes_count = user_notes_count;
	}
	public UserData getAssignee() {
		return assignee;
	}
	public void setAssignee(UserData assignee) {
		this.assignee = assignee;
	}
	public UserData getAuthor() {
		return author;
	}
	public void setAuthor(UserData author) {
		this.author = author;
	}
	public String getUpvotes() {
		return upvotes;
	}
	public void setUpvotes(String upvotes) {
		this.upvotes = upvotes;
	}
	public String getDownvotes() {
		return downvotes;
	}
	public void setDownvotes(String downvotes) {
		this.downvotes = downvotes;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getConfidential() {
		return confidential;
	}
	public void setConfidential(String confidential) {
		this.confidential = confidential;
	}
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
	
}
/*
 {
    "id": 785,
    "iid": 19,
    "project_id": 109,
    "title": "issue 20",
    "description": "api gitlab - test",
    "state": "opened",
    "created_at": "2017-03-08T17:27:08.153Z",
    "updated_at": "2017-03-08T19:39:06.529Z",
    "labels": [
      "Alto",
      "SGA",
      "To Do",
      "UGTSIJ"
    ],
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
    "assignee": {
      "name": "Alejandra Maqueda Policarpo",
      "username": "AMaquedaP",
      "id": 32,
      "state": "active",
      "avatar_url": "http://www.gravatar.com/avatar/5d988106eba63d7c5ad0e3f314d82c2a?s=80&d=identicon",
      "web_url": "http://gitlab.scjn.pjf.gob.mx/AMaquedaP"
    },
    "author": {
      "name": "Alejandra Maqueda Policarpo",
      "username": "AMaquedaP",
      "id": 32,
      "state": "active",
      "avatar_url": "http://www.gravatar.com/avatar/5d988106eba63d7c5ad0e3f314d82c2a?s=80&d=identicon",
      "web_url": "http://gitlab.scjn.pjf.gob.mx/AMaquedaP"
    },
    "user_notes_count": 2,
    "upvotes": 0,
    "downvotes": 0,
    "due_date": "2017-02-20",
    "confidential": false,
    "web_url": "http://gitlab.scjn.pjf.gob.mx/AMaquedaP/buscador/issues/19"
  },
  
   * */
 