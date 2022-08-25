package com.example.advanced.trace.traceV1;

import com.example.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class TraceV2Test {
    @Test
    void begin_end() {
        TraceV2 traceV2 = new TraceV2();
        TraceStatus status = traceV2.begin("hello");
        TraceStatus status2 = traceV2.beginSync(status.getTraceId(), "hello2");
        traceV2.end(status2);
        traceV2.end(status);
    }

    @Test
    void begin_exception() {
        TraceV2 traceV2 = new TraceV2();
        TraceStatus status = traceV2.begin("hello");
        TraceStatus status2 = traceV2.beginSync(status.getTraceId(), "hello2");
        traceV2.exception(status2, new IllegalStateException());
        traceV2.exception(status, new IllegalStateException());
    }

}