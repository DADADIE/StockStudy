package com.supersoft.stockStudy.enums;

public enum ProviderInfo {

	DFCF("东方财富网"
			,"http://ff.eastmoney.com/EM_CapitalFlowInterface/api/js?id=stockCodeTag&type=ff&check=MLBMS&rtntype=3&_="+System.currentTimeMillis());
	
	private String name;
	private String mainCapitalFlowUrl;
	
	ProviderInfo(String name, String mainCapitalFlowUrl){
		this.name = name;
		this.mainCapitalFlowUrl = mainCapitalFlowUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMainCapitalFlowUrl() {
		return mainCapitalFlowUrl;
	}

	public void setMainCapitalFlowUrl(String mainCapitalFlowUrl) {
		this.mainCapitalFlowUrl = mainCapitalFlowUrl;
	}
}
