package com.scjn.gitlabauthapp.domain.model.gitlab.data;

public class IdentityData {
	private String provider;
	private String extern_uid;
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getExtern_uid() {
		return extern_uid;
	}
	public void setExtern_uid(String extern_uid) {
		this.extern_uid = extern_uid;
	}
	
}

/*
 *	  "identities": [
	    {
	      "provider": "ldapmain",
	      "extern_uid": "CN=Alejandra Maqueda Policarpo,OU=Dir Sistemas Juridico-Admin,OU=SubGral Sistemas Informaticos,OU=SCJN DGTI,DC=scjn,DC=PJF,DC=gob,DC=mx"
	    }
	  ], 
 * */
 