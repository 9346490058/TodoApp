package com.qacart.com.testcases;

import com.qacart.com.Api.TasksApi;
import com.qacart.com.base.BaseTest;
import com.qacart.com.Api.RegisterApi;
import com.qacart.com.pages.LoginPage;
import com.qacart.com.pages.NewTodoPage;
import com.qacart.com.pages.TodoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Test(description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewTodo() throws InterruptedException {
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();

       NewTodoPage newTodoPage=new NewTodoPage(getDriver());
        newTodoPage.loadLoginOnly();
        //This thread because test Only to see how it is inject cookies in browser
        // Thread.sleep(5000);
        //Here We are Login by using Api(Restassured) by using Cookies
        injectCookiesToBrowser(registerApi.getCookies());
            String actuallResult= newTodoPage.load()
             .addNewTodoTask("Learn Api").getTodoText();

        Assert.assertEquals(actuallResult, "Learn Api");

    }
    @Story("Delete Todo")
    @Test(description ="Should be able to delete a todo Correctly")
    public void shouldBeAbleToDeleteTodo() {

     RegisterApi registerApi=new RegisterApi();
     registerApi.register();

        TasksApi tasksApi=new TasksApi();
        tasksApi.addTask(registerApi.getToken());

        TodoPage todoPage=new TodoPage(getDriver());
        todoPage.load();

     injectCookiesToBrowser(registerApi.getCookies());

        boolean IsNoTodoMessageDisplay = todoPage.load().
                clickOnDeleteButton().
                NoTodoMessageDisplayed();

        Assert.assertTrue(IsNoTodoMessageDisplay);

    }


}
