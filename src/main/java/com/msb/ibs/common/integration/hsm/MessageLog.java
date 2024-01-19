package com.msb.ibs.common.integration.hsm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageLog {
    private String request;
    private String response;
    private String dateExpired;
}
