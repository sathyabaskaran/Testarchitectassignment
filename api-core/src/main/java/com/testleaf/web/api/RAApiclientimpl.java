package com.testleaf.web.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RAApiclientimpl implements APIClient {

	public ResponseAPI get(String endPoint) {
		 
		return new RAResponseAPIImpl(RestAssured.get(endPoint));
	}

	public ResponseAPI post(String endPoint, Object body) {
		Response response = RestAssured.given().contentType(ContentType.JSON).body(body).when().post(endPoint);
		return new RAResponseAPIImpl(response);
	}

	public ResponseAPI put(String endPoint, Object body) {
		Response response = RestAssured.given().contentType(ContentType.JSON).body(body).when().put(endPoint);
		return new RAResponseAPIImpl(response);
	}

	public ResponseAPI delete(String endPoint) {
		return new RAResponseAPIImpl(RestAssured.delete(endPoint));
	}
	

}
