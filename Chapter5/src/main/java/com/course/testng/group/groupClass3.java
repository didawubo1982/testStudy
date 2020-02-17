package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class groupClass3 {
    public void test1() {
        System.out.println("Teacher中的tea1");
    }

    public void test2() {
        System.out.println("Teacher中的tea2");
    }

}
