package com.data.dao.service.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.data.dao.service.mongo.model.User;


public interface UserDAO extends MongoRepository<User, String> {
    
    @Query("{'uniqId': ?0}")
    User findByGivenuniqId(String id);
    
}
