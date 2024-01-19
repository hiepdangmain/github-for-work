package com.msb.ibs.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paging <T> implements Serializable {
    private int page;
    private int pageSize;
    private long total;
    private List<T> items;
}
