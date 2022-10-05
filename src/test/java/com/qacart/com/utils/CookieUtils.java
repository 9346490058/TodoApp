package com.qacart.com.utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(List<Cookie>restAssuredCookies)
    {
        List<org.openqa.selenium.Cookie>SeleniumCookies=new ArrayList<>();
        for(Cookie cookie:restAssuredCookies)
        {
            org.openqa.selenium.Cookie SeleniumCookie=new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            SeleniumCookies.add(SeleniumCookie);
        }
        //Here we are get Cookies from RestAssured(API) Then Convert to SeleniumCookies
        return SeleniumCookies;
    }

}
