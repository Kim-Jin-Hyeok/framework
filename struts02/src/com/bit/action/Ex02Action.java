package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex02Action implements Action{
	private String id;
	private String pw;
	
	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(id);
		return this.SUCCESS;
	}
}
