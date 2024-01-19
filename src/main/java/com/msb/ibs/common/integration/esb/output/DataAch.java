package com.msb.ibs.common.integration.esb.output;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
@Data
@NoArgsConstructor
public class DataAch {
    private String accNum;
    private String accHolderName;
    private String ref;
    private String type;
    private String message;
    private String coreRef;
    private String duplicated;
}
