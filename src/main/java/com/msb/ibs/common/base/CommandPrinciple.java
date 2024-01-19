package com.msb.ibs.common.base;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

public interface CommandPrinciple <I, O, U> {

    void validate(I request, U principle, HttpServletRequest httpRequest);

    O process(I request, U principle, HttpServletRequest httpRequest);

    Object doInBackground();

    default O execute(I request, U principle, HttpServletRequest httpRequest) {
        validate(request, principle, httpRequest);
        O result = process(request, principle, httpRequest);
        CompletableFuture.supplyAsync(() -> get());
        return result;
    }

    default I get() {
        try {
            doInBackground();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
