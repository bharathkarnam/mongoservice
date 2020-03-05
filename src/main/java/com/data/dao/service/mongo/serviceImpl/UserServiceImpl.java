package com.data.dao.service.mongo.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.dao.service.mongo.dao.UserDAO;
import com.data.dao.service.mongo.model.User;
import com.data.dao.service.mongo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userdao;

	public User insertUser(User user) {
		try {
			return checkForerror(userdao.insert(user));
		} catch (Exception e) {
			logger.error("error while fetching from mongo");
			return null;
		}
	}

	public User checkForerror(User user) {
		if (null != user) {
			return user;
		} else {
			logger.error("error while fetching from mongo");
			return null;
		}

	}

	public User viewUser(String uniqId) {
		try {
			return checkForerror(userdao.findByGivenuniqId(uniqId));
		} catch (Exception e) {
			logger.error("error while processing " + e.getMessage());
			return null;
		}
	}

}