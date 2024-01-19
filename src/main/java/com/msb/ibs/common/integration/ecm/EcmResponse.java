package com.msb.ibs.common.integration.ecm;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EcmResponse {
	private UploadFileResponse uploadFileResponse;
	private DownloadFileResponse downloadFileResponse;
	public UploadFileResponse getUploadFileResponse() {
		return uploadFileResponse;
	}
	public void setUploadFileResponse(UploadFileResponse uploadFileResponse) {
		this.uploadFileResponse = uploadFileResponse;
	}
	public DownloadFileResponse getDownloadFileResponse() {
		return downloadFileResponse;
	}
	public void setDownloadFileResponse(DownloadFileResponse downloadFileResponse) {
		this.downloadFileResponse = downloadFileResponse;
	}
	
}
