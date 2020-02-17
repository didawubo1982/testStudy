package com.course.testng.suite;

import org.testng.annotations.Test;

public class RunTimeTest {

    @Test(timeOut = 2000)
    public void runTimeTest() throws InterruptedException {
        System.out.println("111");
        Thread.sleep(3000);
    }
}
