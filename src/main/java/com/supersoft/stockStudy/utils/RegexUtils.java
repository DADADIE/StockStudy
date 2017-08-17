package com.supersoft.stockStudy.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

	public static String getFirstMatchResult(String srcStr, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(srcStr);
		ArrayList<String> strs = new ArrayList<String>();
		while (m.find()) {
			strs.add(m.group(1));
		}
		return strs.get(0);
	}
}
