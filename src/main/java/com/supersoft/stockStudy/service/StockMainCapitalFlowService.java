package com.supersoft.stockStudy.service;

import com.supersoft.stockStudy.pojo.StockMainCapitalFlow;

/**
 * User:hacker Date:2017/04/07 Time:22:51 Description:This class is created to
 * ...
 */
public interface StockMainCapitalFlowService {

	public boolean addMainCapitalFlowData(StockMainCapitalFlow stockMainCapitalFlow);

	public StockMainCapitalFlow realTimeData(String stockCode);
}
