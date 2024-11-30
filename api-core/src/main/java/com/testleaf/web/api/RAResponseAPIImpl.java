package com.testleaf.web.api;

import java.util.Map;
import java.util.stream.Collectors;

import io.restassured.response.Response;

public class RAResponseAPIImpl implements ResponseAPI{
	
	private Response response;

	public RAResponseAPIImpl(Response response) {
		this.response = response;
	}

	public int getStatusCode() {
		 
		return response.getStatusCode();
	}

	public String getStatusMessage() {
		
		return response.getStatusLine();
	}

	public String getBody() {
		
		return response.getBody().asString();
	}

	public Map<String, String> getHeaders() {
		return response.getHeaders().asList().stream().collect(Collectors.toMap(h -> h.getName(), h -> h.getValue()));
	}

}
