package com.example.advanced;

import com.example.advanced.trace.logTrace.LogTrace;
import com.example.advanced.trace.logTrace.ThreadLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
        return new ThreadLogTrace();
    }
}
