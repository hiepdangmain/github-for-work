package com.msb.ibs.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.msb.ibs.common.enums.LanguageEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TXStatus {
	@JsonProperty("tx_status")
	private String code;
	@JsonProperty("statEN_desc")
	private String desc;
	@JsonProperty("VN_display_name")
	private String displayName;
	@JsonProperty("EN_display_name")
	private String displayNameEng;

	public String getDisplayName(String lang) {
		if (LanguageEnum.EN.getLang().equalsIgnoreCase(lang)) {
			return displayNameEng;
		}
		return displayName;
	}
}

