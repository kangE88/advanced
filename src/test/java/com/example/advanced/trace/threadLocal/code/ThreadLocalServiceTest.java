package com.example.advanced.trace.threadLocal.code;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

@Slf4j
class ThreadLocalServiceTest {
    private final ThreadLocalService threadLocalService = new ThreadLocalService();

    @SneakyThrows
    @Test
    void field(){
        log.info("main start");
        Runnable userA;
        userA = () -> {
            threadLocalService.logic("userA");
        };
        Runnable userB;
        userB = () -> {
            threadLocalService.logic("userB");
        };

        Thread threadA = new Thread(userA);
                threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
                threadB.setName("thread-B");

        threadA.start();
//        sleep(2000);
        sleep(100);
        threadB.start();
        sleep(3000);

        log.info("main exit");

    }

}