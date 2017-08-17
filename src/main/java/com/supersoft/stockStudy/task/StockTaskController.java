package com.supersoft.stockStudy.task;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supersoft.stockStudy.pojo.StockMainCapitalFlow;
import com.supersoft.stockStudy.service.StockMainCapitalFlowService;

/**
 * @author 关军浦
 * @date 2017-04-25
 * @description 定时
 */
@Controller
@RequestMapping("task")
public class StockTaskController {

	@Resource
	StockMainCapitalFlowService stockMainCapitalFlowService;

	@RequestMapping("/addMainCapitalFlowData")
	@ResponseBody
	public boolean addMainCapitalFlowData(StockMainCapitalFlow stockMainCapitalFlow) {
		return stockMainCapitalFlowService.addMainCapitalFlowData(stockMainCapitalFlow);
	}
}
