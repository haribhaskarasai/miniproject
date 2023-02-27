package com.stg.entity;

public class ResponseError {
	private String errorMsg;
	private String requestedURI;

	public ResponseError() {
		super();
	}

	public ResponseError(String errorMsg, String requestedURI) {
		super();
		this.errorMsg = errorMsg;
		this.requestedURI = requestedURI;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

}
