package com.msb.ibs.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class TXResponseCode {
	@JsonProperty("err_num")
	private String code;
	@JsonProperty("tx_status")
	private String txStatus;
	@JsonProperty("err_desc")
	private String desc;
	@JsonProperty("err_en_desc")
	private String descEng;
	@JsonProperty("err_type")
	private String errType;
	@JsonProperty("VN_display_name")
	private String displayName;
	@JsonProperty("EN_display_name")
	private String displayNameEng;
}

