package com.supersoft.stockStudy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supersoft.stockStudy.service.HelloWorldService;

/**
 * @author 关军浦
 * @date 2017-04-06
 * @description 首页
 */
@Controller
@RequestMapping("api/home")
public class HomeController {

	@Resource
	private HelloWorldService helloWorldServiceImpl;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/")
	@ResponseBody
	public String entry(HttpServletRequest request) {
		return null;
	}
}
