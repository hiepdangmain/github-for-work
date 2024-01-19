package com.msb.ibs.common.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InputMessageLog {
    private String tranSn;
    private String reqId;
    private String reqUri;
    private String reqBody;
    private String resBody;
    private String sendDate;
}
