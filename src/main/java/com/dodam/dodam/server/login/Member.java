package com.dodam.dodam.server.login;

public class Member {

	private String id;
	private String name;
	private Long phonenumber;
	private String email;
	private String gender;
	private Long password;
	private int connectioncode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPassword() {
		return password;
	}

	public void setPassword(Long password) {
		this.password = password;
	}

	public int getConnectioncode() {
		return connectioncode;
	}

	public void setConnectioncode(int connectioncode) {
		this.connectioncode = connectioncode;
	}
}