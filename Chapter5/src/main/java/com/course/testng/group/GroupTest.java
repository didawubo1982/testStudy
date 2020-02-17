package com.course.testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupTest {

    @Test(groups = "server")
    public void test1() {
        System.out.println("server1");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("server2");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("client1");
    }

    @Test(groups = "client")
    public void test4() {
        System.out.println("client2");
    }

    @BeforeGroups("server")
    public void test5() {
        System.out.println("before server");
    }

    @AfterGroups("server")
    public void test6() {
        System.out.println("after server");
    }

    @BeforeGroups("client")
    public void test7() {
        System.out.println("before client");
    }

    @AfterGroups("client")
    public void test8() {
        System.out.println("after client");
    }

}
