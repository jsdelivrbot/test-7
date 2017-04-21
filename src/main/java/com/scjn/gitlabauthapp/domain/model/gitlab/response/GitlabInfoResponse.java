package com.scjn.gitlabauthapp.domain.model.gitlab.response;

import java.io.Serializable;

public class GitlabInfoResponse  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String clientId ;

	private String redirectURI;
		
	private String authorizeURL ;

	private String state ;
	
	private String responseType ;

	private String apiURL;
	
	private String gitlabApiURL = "http://gitlab.scjn.pjf.gob.mx/api/v4";
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRedirectURI() {
		return redirectURI;
	}

	public void setRedirectURI(String redirectURI) {
		this.redirectURI = redirectURI;
	}

	public String getAuthorizeURL() {
		return authorizeURL;
	}

	public void setAuthorizeURL(String authorizeURL) {
		this.authorizeURL = authorizeURL;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}

	public String getGitlabApiURL() {
		return gitlabApiURL;
	}

	public void setGitlabApiURL(String gitlabApiURL) {
		this.gitlabApiURL = gitlabApiURL;
	}

	
	
}
