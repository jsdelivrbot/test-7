package com.scjn.gitlabauthapp.web.rest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.core.JsonGenerationException;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.codahale.metrics.annotation.Timed;
import com.scjn.gitlabauthapp.domain.model.gitlab.dto.GitlabInfoDTO;
import com.scjn.gitlabauthapp.domain.model.gitlab.request.GitlabCollectionRequest;
import com.scjn.gitlabauthapp.domain.model.gitlab.response.GitlabIssueResponse;
import com.scjn.gitlabauthapp.domain.model.gitlab.response.GitlabProjectResponse;
import com.scjn.gitlabauthapp.domain.model.gitlab.response.GitlabUserResponse;
@RestController
@RequestMapping("/gitlab/api")
public class GitlabUserResource {
 	private final Logger log = LoggerFactory.getLogger(GitlabUserResource.class);

	
 	//@Autowired
 	//private RestTemplate restTemplate;
 	RestTemplate restTemplate = new RestTemplate();
    @Autowired
 	private GitlabInfoDTO info;
    
    @Timed
    @RequestMapping(value="/user", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GitlabUserResponse> getUser(@Valid GitlabCollectionRequest request){
            //throws URISyntaxException, JsonGenerationException, JsonMappingException, IOException {
            
    		//RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			String url = info.getGitlabApiURL();
			url = url + "/user";
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					.queryParam("access_token", request.getToken())
					.queryParam("per_page", request.getItems())
					.queryParam("page", request.getPage())	;
			ParameterizedTypeReference<GitlabUserResponse> responseType = new ParameterizedTypeReference<GitlabUserResponse>(){};
			GitlabUserResponse response = null;
			try{
				ResponseEntity<GitlabUserResponse> exchange = this.restTemplate.exchange(builder.buildAndExpand(url).toUri(),
			            HttpMethod.GET, null, responseType);
				response = exchange.getBody();
			}catch(HttpClientErrorException ex){
				if(ex.getRawStatusCode()==401){
					return new ResponseEntity<>(response, headers, HttpStatus.UNAUTHORIZED);
					
				}else{
					log.debug("internal server error"+ex.getRawStatusCode());
					log.debug("internal server error"+ex.getResponseBodyAsString());
					log.debug("internal server error"+ex.getMessage());
					log.debug("internal server error"+ex.getCause());
					log.debug("internal server error"+ex.getMostSpecificCause());
					log.debug("internal server error"+ex.getStatusText());
					log.debug("internal server error"+ex.getResponseHeaders().toString());
	   			 	return new ResponseEntity<>(response, headers, HttpStatus.INTERNAL_SERVER_ERROR);
   			 	}
			}catch(Exception other_ex){
				return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
			}			
			return new ResponseEntity<>(response, headers, HttpStatus.OK);
           
    }
    @Timed
    @RequestMapping(value="/user/projects", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
   
    public ResponseEntity<List<GitlabProjectResponse>> getProjects(@Valid GitlabCollectionRequest request)
           {
            
    		//RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			String url = info.getGitlabApiURL();
			url = url + "/projects";
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					.queryParam("access_token", request.getToken())
					.queryParam("per_page", request.getItems())
					.queryParam("page", request.getPage())	;
						
			ParameterizedTypeReference<List<GitlabProjectResponse>> responseType = new ParameterizedTypeReference<List<GitlabProjectResponse>>(){
			};
			List<GitlabProjectResponse> response= null;
			try{
				ResponseEntity<List<GitlabProjectResponse>> exchange = this.restTemplate.exchange(builder.buildAndExpand(url).toUri(),
				            HttpMethod.GET, null, responseType);
	
				
				headers.set("X-Next-Page", exchange.getHeaders().get("X-Next-Page").get(0));
				headers.set("X-Page", exchange.getHeaders().get("X-Page").get(0));
				headers.set("X-Per-Page", exchange.getHeaders().get("X-Per-Page").get(0));
				headers.set("X-Prev-Page", exchange.getHeaders().get("X-Prev-Page").get(0));
				headers.set("X-Total", exchange.getHeaders().get("X-Total").get(0));
				headers.set("X-Total-Pages", exchange.getHeaders().get("X-Total-Pages").get(0));
				response = exchange.getBody();
			}catch(HttpClientErrorException ex){
				if(ex.getRawStatusCode()==401){
					return new ResponseEntity<>(response, headers, HttpStatus.UNAUTHORIZED);
					
				}else{
					log.debug("internal server error"+ex.getRawStatusCode());
					log.debug("internal server error"+ex.getResponseBodyAsString());
					log.debug("internal server error"+ex.getMessage());
					log.debug("internal server error"+ex.getCause());
					log.debug("internal server error"+ex.getMostSpecificCause());
					log.debug("internal server error"+ex.getStatusText());
					log.debug("internal server error"+ex.getResponseHeaders().toString());
	   			 	return new ResponseEntity<>(response, headers, HttpStatus.INTERNAL_SERVER_ERROR);
   			 	}
			}catch(Exception other_ex){
				return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(response, headers	, HttpStatus.OK);
           
    }
    
    @Timed
    @RequestMapping(value="/user/projects/{projectId}/issues", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<GitlabIssueResponse>> getIssuesbyProject(@PathVariable(value="projectId") String projectId, @Valid GitlabCollectionRequest request)
            {
            
    		//RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			String url = info.getGitlabApiURL();
			url = url + "/projects/"+ projectId+ "/issues";
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					.queryParam("access_token", request.getToken())
					.queryParam("per_page", request.getItems())
					.queryParam("page", request.getPage())	;


			ParameterizedTypeReference<List<GitlabIssueResponse>> responseType = new ParameterizedTypeReference<List<GitlabIssueResponse>>(){
			};
			List<GitlabIssueResponse> response= null;
			try{
				ResponseEntity<List<GitlabIssueResponse>> exchange = this.restTemplate.exchange(builder.buildAndExpand(url).toUri(),
				            HttpMethod.GET, null, responseType);
				headers.set("X-Next-Page", exchange.getHeaders().get("X-Next-Page").get(0));
				headers.set("X-Page", exchange.getHeaders().get("X-Page").get(0));
				headers.set("X-Per-Page", exchange.getHeaders().get("X-Per-Page").get(0));
				headers.set("X-Prev-Page", exchange.getHeaders().get("X-Prev-Page").get(0));
				headers.set("X-Total", exchange.getHeaders().get("X-Total").get(0));
				headers.set("X-Total-Pages", exchange.getHeaders().get("X-Total-Pages").get(0));
				response = exchange.getBody();
			}catch(HttpClientErrorException ex){
				if(ex.getRawStatusCode()==401){
					return new ResponseEntity<>(response, headers, HttpStatus.UNAUTHORIZED);
					
				}else{
					log.debug("internal server error"+ex.getRawStatusCode());
					log.debug("internal server error"+ex.getResponseBodyAsString());
					log.debug("internal server error"+ex.getMessage());
					log.debug("internal server error"+ex.getCause());
					log.debug("internal server error"+ex.getMostSpecificCause());
					log.debug("internal server error"+ex.getStatusText());
					log.debug("internal server error"+ex.getResponseHeaders().toString());
	   			 	return new ResponseEntity<>(response, headers, HttpStatus.INTERNAL_SERVER_ERROR);
   			 	}
			}catch(Exception other_ex){
				return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(response, headers, HttpStatus.OK);
           
    }
}