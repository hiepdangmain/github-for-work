package com.msb.ibs.common.integration.esb.output;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EsbRespMessage {
    private String respArr;
    private String respCode;
    private String respDesc;
    private String process;
    private String refNo;
}
