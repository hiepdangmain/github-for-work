package com.msb.ibs.common.integration.esb.output;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
@Data
@NoArgsConstructor
public class EnquiryInfo {
	private List<BillingOrder> orders;
	
}
