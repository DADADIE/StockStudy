package com.supersoft.stockStudy.crawler.datamining;

import org.springframework.stereotype.Component;

import com.supersoft.stockStudy.utils.RegexUtils;

@Component
public class DataMining {

	public static String getKeyData(String resource, String regex) {
		return RegexUtils.getFirstMatchResult(resource, regex);
	}
	
}
