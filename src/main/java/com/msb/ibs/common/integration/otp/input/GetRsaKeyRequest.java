package com.msb.ibs.common.integration.otp.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRsaKeyRequest {
    String userKey;
}