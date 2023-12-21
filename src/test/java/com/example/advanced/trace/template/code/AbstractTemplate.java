package com.example.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {
    public void execute() {
        long startTime = System.currentTimeMillis();
        call();
        long endTime = System.currentTimeMillis();
        long resultime = endTime - startTime;
        log.info("resultime ::: > "+resultime);
    }

    protected abstract void call();
}
