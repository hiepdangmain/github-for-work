package com.msb.ibs.common.integration.esb.input;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EsbBaseRequest {
    private EsbAuthInfo authenInfo;
    private EsbCommonInfo commonInfo;
}
