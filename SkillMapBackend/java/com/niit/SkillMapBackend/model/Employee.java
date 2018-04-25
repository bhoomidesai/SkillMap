package com.niit.SkillMapBackend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	private int employee_id;
	@NonNull
	@Column(name = "email", unique = true)
	private String employee_email;
	@Column
	@NonNull
	private String employee_name;
	@Column
	@NonNull
	private String password;
	/*@Column
	private Date employee_DOJ;
	@Column
	private String role;
	@Column
	private String city;
	@Column
	private String contact_no;
	@Column
	private int rating;
	@Column
	private int total_student_tought;
	@Column
	private int total_hours_tought;
	@Column
	private float placement_per;
	@Column
	private String skills;
	@Column
	private String placement_companies;
	@Column
	private String certifications;*/
	@Column
	private boolean status;

	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
			this.employee_id = employee_id;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		
			this.employee_email = employee_email;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
			this.employee_name = employee_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
			this.password = password;
	}
}
