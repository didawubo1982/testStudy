package com.course.httpclinet.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GetCookiesTest {
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
    public void getWithCookiesTest() throws IOException {
        String cookiesurl = bundle.getString("getwithcookies");
        String testurl = this.url + cookiesurl;
        System.out.println(testurl);
        HttpGet httpGet = new HttpGet(testurl);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.setCookieStore(cookieStore);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        int statuscode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statuscode);
        System.out.println(result);
    }
}
