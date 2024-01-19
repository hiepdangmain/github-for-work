package com.msb.ibs.common.integration.esb.output;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EsbRespDomain {
    private String acctNumber;
    private String accessToken;
    private String tokenType;
	private String coreBankDate;
	private String coreBankMode;
	private String enquiryInfo1;
	private EnquiryInfo enquiryInfo;
	private String discountAmount;
	private String responseCode;
	private String vanumberIsAutoOnboard;
	private String vaseqNumber;
	private String vanumberIsMaster;
	private String vamasterNumber;
	private String acctName;
	private String vanumber;
	private String vaname;
	private String acctCurrency;
	private String isService;
	private String vaserviceCode;
	private String vaserviceName;
	private String vadetail;
	private String vadetai2;
	private String vadetai3;
	private String vadetai4;
	private String vadetai5;
	private String moreInfo;
	private String responseDesc;
	private String acctType;
	private String infor;
	private DataAch dataAch;
	private String holdSeq;

	private String id;
	private String porTransactionId;
	private String statusCode;
	private String statusDescription;
}
