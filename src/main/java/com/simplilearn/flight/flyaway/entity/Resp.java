package com.simplilearn.flight.flyaway.entity;

public class Resp {
	private boolean status;
	private String message;
	private String token;
	
	public Resp(){}
	
	public Resp(boolean status, String message, String token) {
		this.status = status;
		this.message = message;
		this.token = token;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
