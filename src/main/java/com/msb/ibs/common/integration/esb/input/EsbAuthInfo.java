package com.msb.ibs.common.integration.esb.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EsbAuthInfo {
    private String req_id;
    private String req_app;
    private String srv;
    private String req_time;
    private String authorizer;
    private String password;
}
