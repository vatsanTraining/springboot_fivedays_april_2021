package com.example.demo;

public class ErrorDetails {

	int rawStatusCode;
	String responseBodyAsString;
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(int rawStatusCode, String responseBodyAsString) {
		super();
		this.rawStatusCode = rawStatusCode;
		this.responseBodyAsString = responseBodyAsString;
	}
	public int getRawStatusCode() {
		return rawStatusCode;
	}
	public void setRawStatusCode(int rawStatusCode) {
		this.rawStatusCode = rawStatusCode;
	}
	public String getResponseBodyAsString() {
		return responseBodyAsString;
	}
	public void setResponseBodyAsString(String responseBodyAsString) {
		this.responseBodyAsString = responseBodyAsString;
	}
	@Override
	public String toString() {
		return "ErrorDetails [rawStatusCode=" + rawStatusCode + ", responseBodyAsString=" + responseBodyAsString + "]";
	}
	
	
	
}
