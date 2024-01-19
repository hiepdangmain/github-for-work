package com.msb.ibs.common.integration.ecm;

import java.util.LinkedHashMap;
import java.util.Map;

public class DownloadFileResponse {
	private RespMessage respMessage;
	Map<String, Object> respDomain = new LinkedHashMap<>();
	
	
	public DownloadFileResponse() {
		super();
	}
	public RespMessage getRespMessage() {
		return respMessage;
	}
	public void setRespMessage(RespMessage respMessage) {
		this.respMessage = respMessage;
	}
	public Map<String, Object> getRespDomain() {
		return respDomain;
	}
	public void setRespDomain(Map<String, Object> respDomain) {
		this.respDomain = respDomain;
	}
}
