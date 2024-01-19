package com.msb.ibs.common.integration.otp.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyRSAResponse {
    String code;
}
