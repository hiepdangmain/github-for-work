package com.msb.ibs.common.integration.otp.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DecryptDataRSA {
    String decryptData;
    String pannerId;
}
