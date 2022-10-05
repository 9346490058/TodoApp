package com.qacart.com.testcases;
import com.qacart.com.base.BaseTest;
import com.qacart.com.factory.DriverFactory;

import com.qacart.com.pages.LoginPage;
import com.qacart.com.pages.TodoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login with Email and password")
    @Description("it will Login by filling the email and the password and navigate to the todo Page")
    @Test(description = "Test the login functionlty using email and password")
    public void ShouldBeAbleToLoginWithEmailAndPassword()
    {

        LoginPage loginPage=new LoginPage(getDriver());
        boolean isWlecomeDisplayed=
                loginPage
                .load().
                login("hatem@example.com","123456")
                .isWelcomeMessageDisplayed();
    }
}
