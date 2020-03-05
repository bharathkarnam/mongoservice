package com.data.dao.service.mongo.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.data.dao.service.common.testsuite.Common;
import com.data.dao.service.mongo.dao.UserDAO;
import com.data.dao.service.mongo.model.User;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.ServerAddress;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userservice;

	@Mock
	UserDAO userdao;
	 
	MockHttpServletRequest request = new MockHttpServletRequest();

	
	
	User usr = Common.buildUserDetails();


	@Test
	public void testInsertUser() throws Exception {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userdao.insert((User) any(User.class))).thenReturn(usr);
		User responseEntity = userservice.insertUser(usr);
		assertThat(responseEntity).isNotNull();
	}

	
	public void testCheckForerror() throws Exception {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.checkForerror((User) any(User.class))).thenReturn(usr);
		User responseEntity = userservice.insertUser(usr);
		assertThat(responseEntity).isNotNull();
	}

	@Test
	public void testViewUser() throws Exception {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.viewUser(any(String.class))).thenReturn(usr);
		User responseEntity = userservice.viewUser(usr.getUniqId());
		assertThat(responseEntity.getUniqId()).isEqualTo(usr.getUniqId());
	}
	
	@Test
	public void testInsertUserexception() throws Exception {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.insertUser((User)(any(User.class)))).thenThrow(new MongoSocketOpenException("Connection closed",new ServerAddress()));
		User responseEntity = userservice.insertUser(usr);
		assertThat(responseEntity).isNull();
	}
	
	@Test
	public void testViewUserexception() throws Exception {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(userservice.viewUser(any(String.class))).thenThrow(new MongoSocketOpenException("Connection closed",new ServerAddress()));
		User responseEntity = userservice.viewUser(usr.getUniqId());
		assertThat(responseEntity).isNull();
	}
}