package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "methodData")
    public void dataProviderTest1(String name, int age) {
        System.out.println("111name is " + name + ";and age is" + age);
    }

    @Test(dataProvider = "methodData")
    public void dataProviderTest2(String name, int age) {
        System.out.println("222name is " + name + ";and age is" + age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodData(Method method) {
        Object[][] object = null;
        if (method.getName().equals("dataProviderTest1"))
            object = new Object[][]{
                    {"zhangsan", 20},
                    {"lisi", 25}};
        else if (method.getName().equals("dataProviderTest2"))
            object = new Object[][]{
                    {"zhaoliu", 40},
                    {"wangwu", 30}};
        return object;
    }


}
