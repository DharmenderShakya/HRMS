package com.example.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

private int  id;
	@Column(name="Employee_FirstName")
private String firstName;
	@Column(name="Employee_lastName")
private  String lastName;
	@Column(name="Employee_email")
private String email;
//	@Column(name="Employee_Address")
//private String address;
	@Column(name="Phone_NO")
	private String phone_no;
@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(
        name = "Employee_Project",
        joinColumns = @JoinColumn(name="Employee_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="Project_id",referencedColumnName = "id")
)
private Set<Project> roles=new HashSet<>();

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="address_Id",referencedColumnName = "id")
private Address address;


@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="quelification_Id",referencedColumnName = "id")
private Quelification quelification;

//@OneToOne(cascade = CascadeType.ALL)
//@JoinColumn(name="Leave_Id",referencedColumnName = "id")
//private LeaveManagement leaveManagment;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public Set<Project> getRoles() {
	return roles;
}
public void setRoles(Set<Project> roles) {
	this.roles = roles;
}
//public String getAddress() {
//	return address;
//}
//public void setAddress(String address) {
//	this.address = address;
//}
public String getPhone_no() {
	return phone_no;
}
public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}

public Employee(int id, String firstName, String lastName, String email, String address, String phone_no,
		Set<Project> roles) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
//	this.address = address;
	this.phone_no = phone_no;
	this.roles = roles;
//	this.leave = leave;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
//public Salary getSalary() {
//	return salary;
//}
//public void setSalary(Salary salary) {
//	this.salary = salary;
//}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public Quelification getQuelification() {
	return quelification;
}
public void setQuelification(Quelification quelification) {
	this.quelification = quelification;
}

//public LeaveManagement getLeaveManagment() {
//	return leaveManagment;
//}
//public void setLeaveManagment(LeaveManagement leaveManagment) {
//	this.leaveManagment = leaveManagment;
//}



}
