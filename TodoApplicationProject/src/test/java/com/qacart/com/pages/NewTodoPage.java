package com.qacart.com.pages;

import com.qacart.com.base.BasePage;
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

    public TodoPage addNewTodoTask(String item)
    {
        newTodoInput.sendKeys(item);
        NewTodoSumbit.click();
        return new TodoPage(driver);
    }

}
