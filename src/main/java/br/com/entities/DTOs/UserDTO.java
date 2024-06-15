package br.com.entities.DTOs;

import java.io.Serializable;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private Double height;
	
	public UserDTO() {
	}

	public UserDTO(String name, String email, Double height) {
		super();
		this.name = name;
		this.email = email;
		this.height = height;
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

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	
}
