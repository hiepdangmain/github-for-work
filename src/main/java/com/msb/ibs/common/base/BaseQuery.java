package com.msb.ibs.common.base;

import java.util.concurrent.CompletableFuture;

public interface BaseQuery<I, O> {

    void validate(I request);

    O process(I request);

    void doInBackground(I request);

    default O execute(I request) {
        validate(request);
        O result = process(request);
        CompletableFuture.supplyAsync(() -> get(request));
        return result;
    }

    default Object get(I request) {
        try {
            doInBackground(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}