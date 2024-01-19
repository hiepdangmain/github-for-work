package com.msb.ibs.common.integration.esb.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
@Data
@NoArgsConstructor
public class BillingOrder {
	@JacksonXmlProperty(localName = "id")
	public String id;
	@JacksonXmlProperty(localName = "bill_no")
	public String billNo;
	@JacksonXmlProperty(localName = "amount")
	public String amount;
	@JacksonXmlProperty(localName = "good_type")
	public String goodType;
	@JacksonXmlProperty(localName = "quantity")
	public String quantity;
	@JacksonXmlProperty(localName = "price")
	public String price;
	@JacksonXmlProperty(localName = "biller_name")
	public String billerName;
	@JacksonXmlProperty(localName = "biller_addr")
	public String billerAddr;
	@JacksonXmlProperty(localName = "bill_status")
	public String billStatus;
	@JacksonXmlProperty(localName = "expire_date")
	public String expireDate;
	@JacksonXmlProperty(localName = "description")
	public String description;
	@JacksonXmlProperty(localName = "paymentType")
	public String paymentType;
	@JacksonXmlProperty(localName = "orderPaymentType")
	public String orderPaymentType;
}
