package com.msb.ibs.common.base;

import javax.servlet.http.HttpServletRequest;

public interface QueryPrinciple<I, O, U> {

    void validate(I request, U principle, HttpServletRequest httpRequest);

    O process(I request, U principle, HttpServletRequest httpRequest);

    default O execute(I request, U principle, HttpServletRequest httpRequest) {
        validate(request, principle, httpRequest);
        return process(request, principle, httpRequest);
    }

}