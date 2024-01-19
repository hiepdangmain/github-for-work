package com.msb.ibs.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputVerifyToken {
    private String tokenNo;
    private String ip;
}

