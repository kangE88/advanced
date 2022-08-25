package com.example.advanced.trace.traceV1;

import com.example.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraceV1Test {
    @Test
    void begin_end() {
        TraceV1 traceV1 = new TraceV1();
        TraceStatus status = traceV1.begin("hello");
        traceV1.end(status);
    }

    @Test
    void begin_exception() {
        TraceV1 traceV1 = new TraceV1();
        TraceStatus status = traceV1.begin("hello");
        traceV1.exception(status, new IllegalStateException());
    }

}