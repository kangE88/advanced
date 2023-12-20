package com.example.advanced.trace.threadLocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {
    private String nameStore;

    public String logic(String name) {
        log.info("save name={} -> name Store={}", name,nameStore);
        nameStore = name;
        sleep(1000);
        log.info("select name Store={}", nameStore);
        return nameStore;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
