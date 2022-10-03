package com.qacart.com.pages;

import com.qacart.com.base.BasePage;
import com.qacart.com.config.EndPoint;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver) {

        super(driver);
    }
    @FindBy(css="[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;

    @FindBy(css="[data-testid=\"submit-newTask\"]")
    private WebElement NewTodoSumbit;

    @Step
    public NewTodoPage load(){
        driver.get("https://qacart-todo.herokuapp.com"+ EndPoint.NEW_TOD_ENDPOINT);
        return this;
    }
    @Step
    public NewTodoPage loadLoginOnly(){
        driver.get("https://qacart-todo.herokuapp.com");
        return this;
    }

@Step
    public TodoPage addNewTodoTask(String item)
    {
        newTodoInput.sendKeys(item);
        NewTodoSumbit.click();
        return new TodoPage(driver);
    }

}
