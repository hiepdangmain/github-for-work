package com.msb.ibs.common.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class DefErrorInfo {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<TXResponseCode> error;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<TXStatus> txStatus;
}

