package com.data.dao.service.common.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import com.data.dao.service.mongo.controller.MainControllerTest;
import com.data.dao.service.mongo.serviceImpl.UserServiceImplTest;

@SpringBootTest
@RunWith(Suite.class)
@ActiveProfiles("test")
@SuiteClasses({MainControllerTest.class,UserServiceImplTest.class})
public class TestSuite {

}
