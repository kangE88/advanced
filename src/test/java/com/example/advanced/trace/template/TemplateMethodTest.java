package com.example.advanced.trace.template;

import com.example.advanced.trace.template.code.AbstractTemplate;
import com.example.advanced.trace.template.code.SubClassLogic1;
import com.example.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {
    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("First:");
        long endTime = System.currentTimeMillis();
        long resultime = endTime - startTime;
        log.info("resultime ::: > "+resultime);
    }
    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("Second:");
        long endTime = System.currentTimeMillis();
        long resultime = endTime - startTime;
        log.info("resultime ::: > "+resultime);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();
        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }
}
