package com.telus.employeesGroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@JsonIgnoreProperties
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name="Employees")
public class Employee {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name = "marital_status")
	private String maritalStatus;
	@Column(name = "salary")
	private Integer salary;
	
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public int getSalary() {
		
		return salary;
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
	public long getId() {
	    return id;
	}
	public void setId(Integer id) {
	    this.id = id;
	}

}

	
	


