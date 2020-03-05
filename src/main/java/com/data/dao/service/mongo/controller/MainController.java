package com.data.dao.service.mongo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.dao.service.mongo.common.Constants;
import com.data.dao.service.mongo.model.User;
import com.data.dao.service.mongo.service.UserService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	UserService service;

	Gson responseJson = new Gson();

	@CrossOrigin(origins = Constants.HTTPS_ALLOWHOST)
	@PostMapping(path = Constants.POST_USERDETAILS, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> insertUserDetails(@RequestBody @Valid User user) {
		try {
			User usr = service.insertUser(user);
			if (null != usr) {
				return new ResponseEntity<String>(responseJson.toJson(usr), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(responseJson.toJson(Constants.SOMETHING_IS_NOT_RIGHT),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(responseJson.toJson(Constants.SOMETHING_IS_NOT_RIGHT),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@CrossOrigin(origins = Constants.HTTPS_ALLOWHOST)
	@PostMapping(path = Constants.GET_USERDETAILS, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getUserDetails(@RequestBody @Valid String uniqId) {
		try {
			if (null == uniqId || uniqId.isEmpty()) {
				return new ResponseEntity<String>(responseJson.toJson(Constants.SOMETHING_IS_NOT_RIGHT),
						HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<String>(responseJson.toJson(service.viewUser(uniqId)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(responseJson.toJson(Constants.SOMETHING_IS_NOT_RIGHT),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
