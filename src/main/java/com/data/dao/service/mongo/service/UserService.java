package com.data.dao.service.mongo.service;

import com.data.dao.service.mongo.model.User;



public interface UserService {

	User insertUser(User pa);
	User viewUser(String id);
}
