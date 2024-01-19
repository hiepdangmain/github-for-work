package com.msb.ibs.common.integration.ecm;

public class DownloadFile {
	private String documentID;

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public DownloadFile(String documentID) {
		this.documentID = documentID;
	}
	
}
