package com.supersoft.stockStudy.crawler.httpClient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.supersoft.stockStudy.enums.ProviderInfo;
import com.supersoft.stockStudy.utils.RegexUtils;

@Component
@SuppressWarnings("deprecation")
public class HttpClient {

	@SuppressWarnings("resource")
	public String getContent(String url) {
		try {
			HttpGet httpRequst = new HttpGet(url);
			HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequst);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = httpResponse.getEntity();
				return EntityUtils.toString(httpEntity);
			} else
				httpRequst.abort();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage().toString();
		}
		return null;
	}

	public static void main(String[] args) {
		String stockCode = "601997";
		HttpClient httpClient = new HttpClient();
		String url = ProviderInfo.DFCF.getMainCapitalFlowUrl().replace("stockCode", stockCode);
		if(stockCode.startsWith("00")){
			url = url.replace("Tag", "2");
		}else if(stockCode.startsWith("60")){
			url = url.replace("Tag", "1");
		}
		JSONArray temp = JSON.parseArray("[" + RegexUtils.getFirstMatchResult(httpClient.getContent(url), "\"ya\":\\[(.*?)\\]") + "]");
		System.out.println(temp.getString(temp.size()-1));
	}
}
