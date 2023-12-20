package com.example.advanced.app.v3;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace trace;
    public void save( String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepositoryV2.save()");

            if (itemId.equals("ex")) {
                throw new IllegalStateException("error");
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
