package com.msb.ibs.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputMenu {
    private Integer moduleId;
    private Integer pModuleId;
    private String moduleName;
    private Integer level;
    private String isShow;
    private Integer seqNo;
}
