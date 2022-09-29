package com.qacart.com.testcases;

import com.qacart.com.base.BaseTest;
import com.qacart.com.factory.DriverFactory;
import com.qacart.com.pages.LoginPage;
import com.qacart.com.pages.NewTodoPage;
import com.qacart.com.pages.TodoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddNewTodo() {
        LoginPage loginPage = new LoginPage(driver);
        TodoPage todo = new TodoPage(driver);
        String actuallResult = loginPage.load().login("hatem@example.com", "123456").clickOnPlusButton()
                .addNewTodoTask("Learn java").getTodoText();

        Assert.assertEquals(actuallResult, "Learn java");

    }

    @Test(enabled = false)
    public void shouldBeAbleToDeleteTodo() {

        LoginPage loginPage = new LoginPage(driver);

        boolean IsNoTodoMessageDisplay = loginPage.load().
                login("hatem@example.com", "123456").
                clickOnPlusButton()
                .addNewTodoTask("Learn Java").
                clickOnDeleteButton().
                NoTodoMessageDisplayed();

        Assert.assertTrue(IsNoTodoMessageDisplay);

    }


}
