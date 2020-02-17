package com.course.testng.multithread;

import org.testng.annotations.Test;

public class MultiThread {

    @Test(invocationCount = 10, threadPoolSize = 3)
    public void threadTest() {
//        System.out.println("111");
        System.out.printf("Theadid: %s%n", Thread.currentThread().getId());
    }
}
