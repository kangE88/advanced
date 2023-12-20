package com.example.advanced.app.v3;

import com.example.advanced.trace.TraceStatus;
import com.example.advanced.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem( String orderId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderServiceV2.orderItem()");
            orderRepository.save(orderId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
