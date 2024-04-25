package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegisterUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
 private String name;
 private String password;
 private String email;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public RegisterUser(int id, String name, String password, String email) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.email = email;
}
public RegisterUser() {
	super();
	// TODO Auto-generated constructor stub
}

 
}
