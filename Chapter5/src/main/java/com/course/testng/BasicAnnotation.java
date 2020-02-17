package com.course.testng;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.testng.annotations.*;
import org.w3c.dom.ls.LSOutput;

public class BasicAnnotation {
    @Test
    public void testCase1() {
        System.out.println("demo");
    }

    @Test
    public void testCase2() {
        System.out.println("testCase2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("测试方法之前运行");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("测试方法之后运行");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass运行");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass运行");
    }

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("beforeSuit运行");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("afterSuit运行");
    }
}
