package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class groupClass2 {
    public void test1() {
        System.out.println("Class2中的stu1");
    }

    public void test2() {
        System.out.println("Class2中的stu2");
    }

}
