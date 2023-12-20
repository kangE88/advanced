package com.example.advanced.app.v2;

import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.traceV1.TraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final TraceV2 trace;

    public void orderItem(TraceId traceId, String orderId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderServiceV2.orderItem()");
            orderRepository.save(status.getTraceId(), orderId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
