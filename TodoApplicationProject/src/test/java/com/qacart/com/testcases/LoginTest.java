package com.qacart.com.testcases;
import com.qacart.com.base.BaseTest;
import com.qacart.com.factory.DriverFactory;

import com.qacart.com.pages.LoginPage;
import com.qacart.com.pages.TodoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword()
    {

        LoginPage loginPage=new LoginPage(driver);
        boolean isWlecomeDisplayed=
                loginPage
                .load().
                login("hatem@example.com","123456")
                .isWelcomeMessageDisplayed();
    }
}
