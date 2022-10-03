package com.qacart.com.pages;

import com.qacart.com.base.BasePage;
import com.qacart.com.config.EndPoint;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todoItem;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodoMessage;

@Step
public TodoPage load(){
    driver.get("https://qacart-todo.herokuapp.com"+ EndPoint.TODO_PAGE_ENDPOINT);
    return this;
}

    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    @Step
    public NewTodoPage clickOnPlusButton() {
        addButton.click();
        return new NewTodoPage(driver);
    }
@Step
    public String getTodoText() {
        return todoItem.getText();

    }
@Step
    public TodoPage clickOnDeleteButton() {
        deleteButton.click();
        return this;
    }

    @Step
    public boolean NoTodoMessageDisplayed() {
        return noTodoMessage.isDisplayed();
    }

}
