package com.msb.ibs.common.integration.ecm;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@JacksonXmlRootElement(localName = "respMessage")
public class RespMessage {
	private String respArr;
	private String respCode;
	private String respDesc;
	private String process;
	private String refNo;
	
	public RespMessage() {
		super();
	}
	public String getRespArr() {
		return respArr;
	}
	public void setRespArr(String respArr) {
		this.respArr = respArr;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespDesc() {
		return respDesc;
	}
	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
}
