package com.quiz.lesson05.model;

public class Member {

	// field
	private String name;
	private String phoneNumber;
	private String Email;
	private String nationality;
	private String Introduce;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIntroduce() {
		return Introduce;
	}
	public void setIntroduce(String introduce) {
		Introduce = introduce;
	}
	
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", phoneNumber=" + phoneNumber + ", Email=" + Email + ", nationality=" + nationality + ", Introduce=" + Introduce + "]";
	}

}
