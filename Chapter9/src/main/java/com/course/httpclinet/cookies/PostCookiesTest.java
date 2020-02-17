package com.course.httpclinet.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class PostCookiesTest {
    String url;
    ResourceBundle bundle;
    CookieStore cookieStore;

    @BeforeTest
    public void getResourse() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void getCookiesTest() throws IOException {
        String cookiesurl = bundle.getString("getcookies");
        String testurl = this.url + cookiesurl;
        System.out.println(testurl);
        HttpGet httpGet = new HttpGet(testurl);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        System.out.println(result);
        cookieStore = httpClient.getCookieStore();
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("Cookie name is " + name + " and Cookie value is " + value);
        }

    }

    @Test(dependsOnMethods = {"getCookiesTest"})
    public void postCookiesTest() throws IOException {
        String cookiesurl = bundle.getString("postwithcookies");
        String testurl = this.url + cookiesurl;
        System.out.println(testurl);
        HttpPost post = new HttpPost(testurl);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        defaultHttpClient.setCookieStore(cookieStore);
        post.setHeader("content-type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "huhansan");
        jsonObject.put("age", "18");
        StringEntity stringEntity = new StringEntity(jsonObject.toString(), "utf-8");
        post.setEntity(stringEntity);
        HttpResponse httpResponse = defaultHttpClient.execute(post);
        String result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        System.out.println(result);
        int statuscode = httpResponse.getStatusLine().getStatusCode();
        if (statuscode == 200) {
            JSONObject jsonObject1 = new JSONObject(result);
            String name = (String) jsonObject.get("name");
            String age = (String) jsonObject.get("age");
            System.out.println("name is " + name);
            System.out.println("age is " + age);
        }


    }
}
