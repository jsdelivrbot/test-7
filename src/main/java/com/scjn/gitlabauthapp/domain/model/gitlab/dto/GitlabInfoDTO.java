package com.scjn.gitlabauthapp.domain.model.gitlab.dto;



import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Configuration
@EnableConfigurationProperties

@ConfigurationProperties(prefix="gitlab")
public class GitlabInfoDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	
    @Value("${gitlab.client-id}")
    private String clientId;
	
    @Value("${gitlab.client-secret}")
    private String clientSecret;
	
    @Value("${gitlab.redirect-u-r-i}")
	private String redirectURI; 
	
	@Value("${gitlab.authorize-u-r-l:}")
	private String authorizeURL;

	@Value("${gitlab.access-token-u-r-l}")
	private String accessTokenURL;
	
	@Value("${gitlab.state}")
	private String state;
	
	@Value("${gitlab.response-type}")
	private String responseType;
		
	@Value("${gitlab.grant-type}")
	private String grantType;
	
	@Value("${gitlab.gitlab-api-u-r-l}")
	private String gitlabApiURL;
	
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

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
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

	public String getAccessTokenURL() {
		return accessTokenURL;
	}

	public void setAccessTokenURL(String accessTokenURL) {
		this.accessTokenURL = accessTokenURL;
	}

	public String getGitlabApiURL() {
		return gitlabApiURL;
	}

	public void setGitlabApiURL(String gitlabApiURL) {
		this.gitlabApiURL = gitlabApiURL;
	}

}
