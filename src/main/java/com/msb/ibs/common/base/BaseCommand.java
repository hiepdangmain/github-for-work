package com.msb.ibs.common.base;

import java.util.concurrent.CompletableFuture;

public interface BaseCommand<I, O, U> {

    void validate(I request, U principle);

    O process(I request, U principle);

    Object doInBackground();

    @SuppressWarnings({ "rawtypes", "unchecked" })
    default O execute(I request, U principle) {
        validate(request, principle);
        O result = process(request, principle);
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