package com.supersoft.stockStudy.service.impl;

import org.springframework.stereotype.Service;

import com.supersoft.stockStudy.service.HelloWorldService;

/**
 * User:hacker Date:2017/04/06 Time:0:36 Description:This class is created to
 * ...
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String SayHello(String name) {
		return "Hello, "+name;
	}

}
