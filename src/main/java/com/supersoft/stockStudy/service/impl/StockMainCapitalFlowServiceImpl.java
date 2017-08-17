package com.supersoft.stockStudy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.supersoft.stockStudy.crawler.datamining.DataMining;
import com.supersoft.stockStudy.crawler.datamining.seed.DFCFDataSeed;
import com.supersoft.stockStudy.crawler.httpClient.HttpClient;
import com.supersoft.stockStudy.dao.StockMainCapitalFlowDao;
import com.supersoft.stockStudy.pojo.StockMainCapitalFlow;
import com.supersoft.stockStudy.service.StockMainCapitalFlowService;

/**
 * User:hacker Date:2017/04/06 Time:0:36 Description:This class is created to
 * ...
 */
@Service
public class StockMainCapitalFlowServiceImpl implements StockMainCapitalFlowService {

	@Resource
	private HttpClient httpClient;
	@Resource
	private StockMainCapitalFlowDao stockMainCapitalFlowDao;

	@Override
	public boolean addMainCapitalFlowData(StockMainCapitalFlow stockMainCapitalFlow) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StockMainCapitalFlow realTimeData(String stockCode) {
		String url = DFCFDataSeed.getSeeds(stockCode);
		String mainCapitalFlow = DataMining.getKeyData(httpClient.getContent(url), "\"ya\":\\[(.*?)\\]");
		JSONArray mainCapitalFlowJSONArray = JSON.parseArray("[" + mainCapitalFlow + "]");
		String mainCapitalFlowTemp = mainCapitalFlowJSONArray.getString(mainCapitalFlowJSONArray.size() - 1);
		String[] mainCapitalFlowArray = mainCapitalFlowTemp.split(",");
		return wrapData(mainCapitalFlowArray);
	}

	private StockMainCapitalFlow wrapData(String[] mainCapitalFlowArray) {
		StockMainCapitalFlow stockMainCapitalFlow = new StockMainCapitalFlow();
		stockMainCapitalFlow.setMainCapitalRetainedFlowToday(mainCapitalFlowArray[0]);
		stockMainCapitalFlow.setSuperOrderRetainedFlowToday(mainCapitalFlowArray[1]);
		stockMainCapitalFlow.setBigOrderRetainedFlowToday(mainCapitalFlowArray[2]);
		stockMainCapitalFlow.setMidOrderRetainedFlowToday(mainCapitalFlowArray[3]);
		stockMainCapitalFlow.setMiniOrderRetainedFlowToday(mainCapitalFlowArray[4]);
		return stockMainCapitalFlow;
	}

}
