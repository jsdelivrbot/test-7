package com.scjn.gitlabauthapp.domain.model.gitlab.response;

import com.scjn.gitlabauthapp.domain.model.gitlab.data.GroupData;
import com.scjn.gitlabauthapp.domain.model.gitlab.data.NamespaceData;
import com.scjn.gitlabauthapp.domain.model.gitlab.data.PermissionData;
import com.scjn.gitlabauthapp.domain.model.gitlab.data.UserData;

public class GitlabProjectResponse {
	private String id;
	private String description;
	private String default_branch;
	//private String[] tag_list;
	private String archived;
	private String visibility;
	private String ssh_url_to_repo;
	private String http_url_to_repo;
	private String web_url;
	private UserData owner;
	private String name;
	private String name_with_namespace;
	private String path;
	private String path_with_namespace;
	private String container_registry_enabled;
	private String issues_enabled;
	private String merge_requests_enabled;
	private String wiki_enabled;
	private String jobs_enabled;
	private String snippets_enabled;
	private String created_at;
	private String last_activity_at;
	private String shared_runners_enabled;
	private String lfs_enabled;
	private String creator_id;
	private NamespaceData namespace;
	private String avatar_url;
	private String star_count;
	private String forks_count;
	private String open_issues_count;
	private String public_jobs;
	private GroupData[] shared_with_groups;
	private String only_allow_merge_if_pipeline_succeeds;
	private String request_access_enabled;
	private String only_allow_merge_if_all_discussions_are_resolved;
	private PermissionData permissions;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDefault_branch() {
		return default_branch;
	}
	public void setDefault_branch(String default_branch) {
		this.default_branch = default_branch;
	}
	/*
	public String[] getTag_list() {
		return tag_list;
	}
	public void setTag_list(String[] tag_list) {
		this.tag_list = tag_list;
	}*/
	public String getArchived() {
		return archived;
	}
	public void setArchived(String archived) {
		this.archived = archived;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getSsh_url_to_repo() {
		return ssh_url_to_repo;
	}
	public void setSsh_url_to_repo(String ssh_url_to_repo) {
		this.ssh_url_to_repo = ssh_url_to_repo;
	}
	public String getHttp_url_to_repo() {
		return http_url_to_repo;
	}
	public void setHttp_url_to_repo(String http_url_to_repo) {
		this.http_url_to_repo = http_url_to_repo;
	}
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
	
	public UserData getOwner() {
		return owner;
	}
	public void setOwner(UserData owner) {
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_with_namespace() {
		return name_with_namespace;
	}
	public void setName_with_namespace(String name_with_namespace) {
		this.name_with_namespace = name_with_namespace;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath_with_namespace() {
		return path_with_namespace;
	}
	public void setPath_with_namespace(String path_with_namespace) {
		this.path_with_namespace = path_with_namespace;
	}
	public String getContainer_registry_enabled() {
		return container_registry_enabled;
	}
	public void setContainer_registry_enabled(String container_registry_enabled) {
		this.container_registry_enabled = container_registry_enabled;
	}
	public String getIssues_enabled() {
		return issues_enabled;
	}
	public void setIssues_enabled(String issues_enabled) {
		this.issues_enabled = issues_enabled;
	}
	public String getMerge_requests_enabled() {
		return merge_requests_enabled;
	}
	public void setMerge_requests_enabled(String merge_requests_enabled) {
		this.merge_requests_enabled = merge_requests_enabled;
	}
	public String getWiki_enabled() {
		return wiki_enabled;
	}
	public void setWiki_enabled(String wiki_enabled) {
		this.wiki_enabled = wiki_enabled;
	}
	public String getJobs_enabled() {
		return jobs_enabled;
	}
	public void setJobs_enabled(String jobs_enabled) {
		this.jobs_enabled = jobs_enabled;
	}
	
	
	public GroupData[] getShared_with_groups() {
		return shared_with_groups;
	}
	public void setShared_with_groups(GroupData[] shared_with_groups) {
		this.shared_with_groups = shared_with_groups;
	}
	public String getSnippets_enabled() {
		return snippets_enabled;
	}
	public void setSnippets_enabled(String snippets_enabled) {
		this.snippets_enabled = snippets_enabled;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getLast_activity_at() {
		return last_activity_at;
	}
	public void setLast_activity_at(String last_activity_at) {
		this.last_activity_at = last_activity_at;
	}
	public String getShared_runners_enabled() {
		return shared_runners_enabled;
	}
	public void setShared_runners_enabled(String shared_runners_enabled) {
		this.shared_runners_enabled = shared_runners_enabled;
	}
	public String getLfs_enabled() {
		return lfs_enabled;
	}
	public void setLfs_enabled(String lfs_enabled) {
		this.lfs_enabled = lfs_enabled;
	}
	public String getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}
	
	public NamespaceData getNamespace() {
		return namespace;
	}
	public void setNamespace(NamespaceData namespace) {
		this.namespace = namespace;
	}
	public String getAvatar_url() {
		return avatar_url;
	}
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	public String getStar_count() {
		return star_count;
	}
	public void setStar_count(String star_count) {
		this.star_count = star_count;
	}
	public String getForks_count() {
		return forks_count;
	}
	public void setForks_count(String forks_count) {
		this.forks_count = forks_count;
	}
	public String getOpen_issues_count() {
		return open_issues_count;
	}
	public void setOpen_issues_count(String open_issues_count) {
		this.open_issues_count = open_issues_count;
	}
	public String getPublic_jobs() {
		return public_jobs;
	}
	public void setPublic_jobs(String public_jobs) {
		this.public_jobs = public_jobs;
	}
	
	public String getOnly_allow_merge_if_pipeline_succeeds() {
		return only_allow_merge_if_pipeline_succeeds;
	}
	public void setOnly_allow_merge_if_pipeline_succeeds(String only_allow_merge_if_pipeline_succeeds) {
		this.only_allow_merge_if_pipeline_succeeds = only_allow_merge_if_pipeline_succeeds;
	}
	public String getRequest_access_enabled() {
		return request_access_enabled;
	}
	public void setRequest_access_enabled(String request_access_enabled) {
		this.request_access_enabled = request_access_enabled;
	}
	public String getOnly_allow_merge_if_all_discussions_are_resolved() {
		return only_allow_merge_if_all_discussions_are_resolved;
	}
	public void setOnly_allow_merge_if_all_discussions_are_resolved(
			String only_allow_merge_if_all_discussions_are_resolved) {
		this.only_allow_merge_if_all_discussions_are_resolved = only_allow_merge_if_all_discussions_are_resolved;
	}
	public PermissionData getPermissions() {
		return permissions;
	}
	public void setPermissions(PermissionData permissions) {
		this.permissions = permissions;
	}


}
/*
  {
    "id": 5,
    "description": "Plantilla para construir proyectos basados en AngularJS con autenticación básica.",
    "default_branch": "master",
    "tag_list": [],
    "archived": false,
    "visibility": "public",
    "ssh_url_to_repo": "git@gitlab.scjn.pjf.gob.mx:lasolisc/adminlte-scjn-ng.git",
    "http_url_to_repo": "http://gitlab.scjn.pjf.gob.mx/lasolisc/adminlte-scjn-ng.git",
    "web_url": "http://gitlab.scjn.pjf.gob.mx/lasolisc/adminlte-scjn-ng",
    "owner": {
      "name": "Luis Antonio Solís Cuevas",
      "username": "lasolisc",
      "id": 2,
      "state": "active",
      "avatar_url": "http://gitlab.scjn.pjf.gob.mx/uploads/user/avatar/2/IMG_0405.jpg",
      "web_url": "http://gitlab.scjn.pjf.gob.mx/lasolisc"
    },
    "name": "adminlte-scjn-ng",
    "name_with_namespace": "Luis Antonio Solís Cuevas / adminlte-scjn-ng",
    "path": "adminlte-scjn-ng",
    "path_with_namespace": "lasolisc/adminlte-scjn-ng",
    "container_registry_enabled": false,
    "issues_enabled": true,
    "merge_requests_enabled": true,
    "wiki_enabled": true,
    "jobs_enabled": true,
    "snippets_enabled": false,
    "created_at": "2015-09-01T17:49:56.035Z",
    "last_activity_at": "2016-02-29T13:58:58.217Z",
    "shared_runners_enabled": true,
    "lfs_enabled": true,
    "creator_id": 2,
    "namespace": {
      "id": 2,
      "name": "lasolisc",
      "path": "lasolisc",
      "kind": "user",
      "full_path": "lasolisc"
    },
    "avatar_url": null,
    "star_count": 0,
    "forks_count": 0,
    "open_issues_count": 0,
    "public_jobs": true,
    "shared_with_groups": [],
    "only_allow_merge_if_pipeline_succeeds": false,
    "request_access_enabled": true,
    "only_allow_merge_if_all_discussions_are_resolved": null,
    "permissions": {
      "project_access": null,
      "group_access": null
    }
  },
 * */
 