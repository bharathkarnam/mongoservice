package com.data.dao.service.mongo.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	@Length(min=2)
	private String name;
	
	private String uniqId;
	
	@NotNull
	private String[] skills;
	@NotNull
	private long mobilenumber;
	@NotNull
	private String address;
	@NotNull
	private float totalyearsOfexperience;
	@Length(min=3)
	private String role;
	@Length(min=3)
	private String designation;
	
	public String getUniqId() {
		return uniqId;
	}

	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}

	public String getName() {
		return name;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotalyearsOfexperience() {
		return totalyearsOfexperience;
	}

	public void setTotalyearsOfexperience(float totalyearsOfexperience) {
		this.totalyearsOfexperience = Math.round(totalyearsOfexperience);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
