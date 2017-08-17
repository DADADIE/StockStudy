package com.supersoft.stockStudy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.supersoft.stockStudy.service.StockMainCapitalFlowService;

@Controller
@RequestMapping("api/stock/mainCapitalFlow")
public class StockMainCapitalFlowController {

	@Resource
	private StockMainCapitalFlowService stockMainCapitalFlowService;

	@RequestMapping("/realTimeData")
	@ResponseBody
	public String realTimeData(String stockCode) {
		return JSON.toJSONString(stockMainCapitalFlowService.realTimeData(stockCode));
	}

	@RequestMapping("/historyData")
	@ResponseBody
	public String historyData(HttpServletRequest request) {
		return null;
	}
}
