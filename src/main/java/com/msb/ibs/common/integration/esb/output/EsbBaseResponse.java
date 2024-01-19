package com.msb.ibs.common.integration.esb.output;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EsbBaseResponse {
	public EsbRespMessage respMessage;
    public EsbRespDomain respDomain;
}
