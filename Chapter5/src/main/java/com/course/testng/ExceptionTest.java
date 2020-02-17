package com.course.testng;

import org.testng.annotations.Test;

public class ExceptionTest {

    @Test(expectedExceptions = RuntimeException.class)
    public void expectException() {
        System.out.println("异常测试");
        throw new RuntimeException();
    }
}
