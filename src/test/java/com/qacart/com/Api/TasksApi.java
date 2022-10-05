package com.qacart.com.Api;

import com.qacart.com.config.EndPoint;
import com.qacart.com.objects.Task;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {
    public void addTask(String token)
    {
        Task task=new Task("Learn Cypress",false);
      Response response=given().baseUri("http://qacart-todo.herokuapp.com")
                .header("Content-Type","application/json")
                .body(task)
                .auth().oauth2(token)
                .when()
                .post(EndPoint.API_TASK_ENDPOINT)
                .then().log().all().extract().response();
      if (response.statusCode()!=201)
      {
          throw new RuntimeException("Something went wrong in adding th todo");
      }

    }
}
