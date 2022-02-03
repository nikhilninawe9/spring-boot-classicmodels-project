package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Component
@JsonInclude(Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private Integer officeCode;
	private Integer reportsTo;
	private String jobTitle;

	public Employees() {
		super();
	}

	public Employees(Integer employeeNumber, String lastName, String firstName, String extension, String email,
			Integer officeCode, Integer reportsTo, String jobTitle) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getExtension() {
		return extension;
	}

	public String getEmail() {
		return email;
	}

	public Integer getOfficeCode() {
		return officeCode;
	}

	public Integer getReportsTo() {
		return reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	@Override
	public String toString() {
		return "Employees [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle + "]";
	}

}
