package com.qacart.com.pages;

import com.qacart.com.base.BasePage;
import com.qacart.com.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.Properties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="[data-testid=\"email\"]")
    private WebElement emailInput;

    @FindBy(css="[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css="[data-testid=\"submit\"]")
    private WebElement submit;



    @Step
    public TodoPage login(String email, String password)
    {
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        this.submit.click();
        return new TodoPage(driver);
    }

    @Step("Load the login page")
    public LoginPage load()
    {
       //Properties prop=PropertiesUtils.loadProperties("src/test/java/com/qacart/com/config/production.properties");

        driver.get("https://qacart-todo.herokuapp.com");
        return this;

    }


}
