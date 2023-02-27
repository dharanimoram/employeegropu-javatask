
package com.telus.employeesGroup.json.pojo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.telus.employeesGroup.model.Employee;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "employee"
})

public class Employees {

    @JsonProperty("employee")
    private List<Employee> employee;
    
    @JsonProperty("employee")
    public List<Employee> getEmployee() {
        return employee;
    }

    @JsonProperty("employee")
    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Employees withEmployee(List<Employee> employee) {
        this.employee = employee;
        return this;
    }

 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Employees.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("employee");
        sb.append('=');
        sb.append(((this.employee == null)?"<null>":this.employee));
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
		return Objects.hash(employee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		return Objects.equals(employee, other.employee);
	}

    

}
