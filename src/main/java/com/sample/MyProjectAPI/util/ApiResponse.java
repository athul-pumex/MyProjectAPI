package com.sample.MyProjectAPI.util;

public class ApiResponse {
	private boolean status;
	private String message;
	private Object data;
	private boolean isError;

	public ApiResponse(boolean status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.isError = false;
	}

	public ApiResponse(boolean status, String message, boolean isError) {
		super();
		this.status = status;
		this.message = message;
		this.isError = isError;
		this.data = null;
	}

	public ApiResponse(boolean status, String message, Object data, boolean isError) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.isError = isError;
	}

	public ApiResponse(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.isError = false;
		this.data = null;
	}

	public ApiResponse() {

	}

	public	boolean
			isStatus() {
		return status;
	}

	public	void
			setStatus(boolean status) {
		this.status = status;
	}

	public	String
			getMessage() {
		return message;
	}

	public	void
			setMessage(String message) {
		this.message = message;
	}

	public	Object
			getData() {
		return data;
	}

	public	void
			setData(Object data) {
		this.data = data;
	}

	public	boolean
			isError() {
		return isError;
	}

	public	void
			setError(boolean isError) {
		this.isError = isError;
	}
}
