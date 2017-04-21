package com.scjn.gitlabauthapp.web.rest;

import java.io.IOException;
import java.net.URISyntaxException;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.core.JsonGenerationException;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.codahale.metrics.annotation.Timed;
import com.scjn.gitlabauthapp.domain.model.gitlab.dto.GitlabInfoDTO;
import com.scjn.gitlabauthapp.domain.model.gitlab.mapper.GitlabInfoMapper;
import com.scjn.gitlabauthapp.domain.model.gitlab.request.GitlabTokenRequest;
import com.scjn.gitlabauthapp.domain.model.gitlab.response.GitlabInfoResponse;
import com.scjn.gitlabauthapp.domain.model.gitlab.response.GitlabTokenResponse;

@RestController
@RequestMapping("/gitlab/api")
public class GitlabConnectionResource {
	 	private final Logger log = LoggerFactory.getLogger(GitlabConnectionResource.class);
	 	//@Autowired
	 	//private RestTemplate restTemplate;
	 	RestTemplate restTemplate = new RestTemplate();
	 	@Autowired
	    private GitlabInfoMapper gitlabInfoMapper;
	    @Autowired
	 	private GitlabInfoDTO info;
	    

		@Timed
	    @RequestMapping(value="/connection", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	    public ResponseEntity<GitlabInfoResponse> getInfo()
	            throws URISyntaxException, JsonGenerationException, JsonMappingException, IOException {
	    		
				HttpHeaders headers = new HttpHeaders();
				GitlabInfoResponse gitlabInfoResponse = gitlabInfoMapper.gitlabInfoDTOToGitlabInfoResponse(info);
				if(gitlabInfoResponse!=null){
					return new ResponseEntity<>(gitlabInfoResponse, headers, HttpStatus.OK);
				}else{
					return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
				}
	    }
	    
	    @Timed
	    @RequestMapping(value="/connection/token", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	    public ResponseEntity<GitlabTokenResponse> getToken(@Valid GitlabTokenRequest gitlabTokenRequest)
	            {
	            log.debug("req code send:"+ gitlabTokenRequest.getCode());
	    		
//----------------------------------------------------------------------------------------------
	    		//RestTemplate restTemplate = new RestTemplate();

	    		MultiValueMap<String,String> parameters = new LinkedMultiValueMap<String,String>();
	    		
	    		parameters.add("client_id", info.getClientId());
	    		parameters.add("client_secret", info.getClientSecret());
	    		parameters.add("code", gitlabTokenRequest.getCode());
	    		parameters.add("grant_type", info.getGrantType());
	    		parameters.add("redirect_uri", info.getRedirectURI());
	    		parameters.add("state", info.getState());
	    			    		
	    		HttpHeaders headers = new HttpHeaders();
	    		//headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	    		final HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(parameters ,
	    		        headers);
	    		GitlabTokenResponse response = null;
	    		try{
	    			ResponseEntity<GitlabTokenResponse> responseEntity = this.restTemplate.exchange(info.getAccessTokenURL(), HttpMethod.POST, entity,
	    					GitlabTokenResponse.class);	    		
	    			response = responseEntity.getBody();
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
	    		
//----------------------------------------------------------------------------------------------	    		
	    		
				

	            return new ResponseEntity<>(response, headers, HttpStatus.OK);
	           
	    }

}
