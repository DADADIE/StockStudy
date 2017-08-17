package com.supersoft.stockStudy.crawler.datamining.seed;

import com.supersoft.stockStudy.enums.ProviderInfo;

public class DFCFDataSeed {

	public static String getSeeds(String stockCode) {
		String url = ProviderInfo.DFCF.getMainCapitalFlowUrl().replace("stockCode", stockCode);
		if (stockCode.startsWith("00")) {
			url = url.replace("Tag", "2");
		} else if (stockCode.startsWith("60")) {
			url = url.replace("Tag", "1");
		}
		return url;
	}

}
