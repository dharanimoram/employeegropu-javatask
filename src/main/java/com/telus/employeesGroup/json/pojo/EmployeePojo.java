
package com.telus.employeesGroup.json.pojo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.telus.employeesGroup.json.pojo.Employee;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"firstName",
	"lastName",
	"email",
	"marritalStatus",
	"salary"
})

public class Employee {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("marritalStatus")
	private String marritalStatus;
	@JsonProperty("salary")
	private Integer salary;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	public Employee withId(Integer id) {
		this.id = id;
		return this;
	}

	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Employee withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	@JsonProperty("lastName")
	public String getLasttName() {
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee withLasttName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	public Employee withEmail(String email) {
		this.email = email;
		return this;
	}

	@JsonProperty("marritalStatus")
	public String getMarritalStatus() {
		return marritalStatus;
	}

	@JsonProperty("marritalStatus")
	public void setMarritalStatus(String marritalStatus) {
		this.marritalStatus = marritalStatus;
	}

	public Employee withMarritalStatus(String marritalStatus) {
		this.marritalStatus = marritalStatus;
		return this;
	}

	@JsonProperty("salary")
	public Integer getSalary() {
		return salary;
	}

	@JsonProperty("salary")
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Employee withSalary(Integer salary) {
		this.salary = salary;
		return this;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Employee .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null)?"<null>":this.id));
		sb.append(',');
		sb.append("firstName");
		sb.append('=');
		sb.append(((this.firstName == null)?"<null>":this.firstName));
		sb.append(',');
		sb.append("lastName");
		sb.append('=');
		sb.append(((this.lastName == null)?"<null>":this.lastName));
		sb.append(',');
		sb.append("email");
		sb.append('=');
		sb.append(((this.email == null)?"<null>":this.email));
		sb.append(',');
		sb.append("marritalStatus");
		sb.append('=');
		sb.append(((this.marritalStatus == null)?"<null>":this.marritalStatus));
		sb.append(',');
		sb.append("salary");
		sb.append('=');
		sb.append(((this.salary == null)?"<null>":this.salary));
		sb.append(',');
		if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}


	@Override
	public int hashCode() {
		return Objects.hash(marritalStatus, email, id, firstName, lastName, salary);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(marritalStatus, other.marritalStatus) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(firstName, other.firstName) 
				&& Objects.equals(lastName, other.lastName)
				&& Objects.equals(salary, other.salary);
	}    





}







