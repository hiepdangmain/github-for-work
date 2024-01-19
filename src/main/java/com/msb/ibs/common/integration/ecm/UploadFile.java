package com.msb.ibs.common.integration.ecm;

public class UploadFile {
	private String chanel; 
	private String projectID;
	private String cif;
	private String customerCode;
	private String folderName;
	private String doccumentTitle;
	private byte[] byteData;
	private String rootFolder;
	private String fileName;

	
	public String getChanel() {
		return chanel;
	}
	public void setChanel(String chanel) {
		this.chanel = chanel;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getDoccumentTitle() {
		return doccumentTitle;
	}
	public void setDoccumentTitle(String doccumentTitle) {
		this.doccumentTitle = doccumentTitle;
	}
	public byte[] getByteData() {
		return byteData;
	}
	public void setByteData(byte[] byteData) {
		this.byteData = byteData;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getRootFolder() {
		return rootFolder;
	}
	public void setRootFolder(String rootFolder) {
		this.rootFolder = rootFolder;
	}
	
	
}

