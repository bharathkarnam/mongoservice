package com.data.dao.service.common.testsuite;

import com.data.dao.service.mongo.model.User;

public class Common {
	public static User buildUserDetails() {
		String[] skill=new String[2];
		skill[0]="spring";
		skill[1]="kotlin";
		User usr = new User();
		String address = "Australia melbourne";
		usr.setAddress(address);
		usr.setDesignation("software dev");
		usr.setMobilenumber(431424709);
		usr.setName("bharath");
		usr.setRole("Development");
		usr.setSkills(skill);
		usr.setTotalyearsOfexperience(8);
		usr.setUniqId("1234");
		return usr;

	}
}
