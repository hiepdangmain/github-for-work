package com.msb.ibs.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metadata {
    long total;
    int page = 1;
    int pageSize = 1000;
}
