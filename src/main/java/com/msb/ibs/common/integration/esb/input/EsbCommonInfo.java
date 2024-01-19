package com.msb.ibs.common.integration.esb.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EsbCommonInfo {
    private String branchCode;
    private String subBranchCode;
    private String channel;
    private String hostName;
    private String teller;
    private String manager;
    private String tranDate;
    private String tranCode;
    private String sysMode;
    private String tranSeq;
}
