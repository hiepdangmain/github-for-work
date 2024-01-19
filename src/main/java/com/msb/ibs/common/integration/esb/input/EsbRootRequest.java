package com.msb.ibs.common.integration.esb.input;

import java.util.HashMap;

public class EsbRootRequest extends HashMap<String, Object> {

    public EsbRootRequest build(String name, Object data) {
        super.put(name, data);
        return this;
    }
}
