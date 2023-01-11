package com.quiz.sns.model;

import java.util.Date;

public class User {
	
	// field
	private int id;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private Date createdAt;
	private Date updatedAt;
	
	// g&s
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", loginId=" + loginId + ", password=" + password + ", name=" + name + ", email=" + email + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	

}
