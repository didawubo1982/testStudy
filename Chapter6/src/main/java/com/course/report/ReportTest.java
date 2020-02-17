package com.course.report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReportTest {

    @Test
    public void test1() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void test2() {
        Assert.assertEquals("aaa", "bbb");
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, 5);
    }

    @Test
    public void logDemo() {
        Reporter.log("这是logdemo");
        throw new RuntimeException("这是logdemo异常");
    }
}
