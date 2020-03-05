package com.data.dao.service.mongo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.data.dao.service.common.testsuite.Common;
import com.data.dao.service.mongo.model.User;
import com.data.dao.service.mongo.service.UserService;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.ServerAddress;

@RunWith(SpringRunner.class)
public class MainControllerTest {

	@InjectMocks
	MainController maincontroller;

	@Mock
	UserService userservice;
	 
	MockHttpServletRequest request = new MockHttpServletRequest();

	
	
	User usr = Common.buildUserDetails();


	@Test
	public void testAddUser() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.insertUser((User) any(User.class))).thenReturn(usr);
		ResponseEntity<String> responseEntity = maincontroller.insertUserDetails(usr);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void testGetUser() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.viewUser(any(String.class))).thenReturn(usr);
		ResponseEntity<String> responseEntity = maincontroller.getUserDetails(usr.getUniqId());
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void testAddUsernull() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.insertUser((User) any(User.class))).thenReturn(null);
		ResponseEntity<String> responseEntity = maincontroller.insertUserDetails(null);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(400);
	}
	
	@Test
	public void testAddUserException() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.insertUser((User) any(User.class))).thenThrow(new MongoSocketOpenException("Connection closed",new ServerAddress()));
		ResponseEntity<String> responseEntity = maincontroller.insertUserDetails(usr);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}
	
	@Test
	public void testGetUsernull() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.viewUser(null)).thenReturn(null);
		ResponseEntity<String> responseEntity = maincontroller.getUserDetails(null);
		System.out.println(responseEntity.getStatusCodeValue());
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(400);
	}
	
	@Test
	public void testGetUserexception() throws Exception {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.viewUser(any(String.class))).thenThrow(new MongoSocketOpenException("Connection closed",new ServerAddress()));
		ResponseEntity<String> responseEntity = maincontroller.getUserDetails(usr.getUniqId());
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}

	
}