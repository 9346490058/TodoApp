package com.qacart.com.Api;

import com.qacart.com.config.EndPoint;
import com.qacart.com.objects.User;
import com.qacart.com.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private static List<Cookie> restAssuredCookies;
    private  static String  accessToken;
    private static String userId;
    private static String firstName;

    public String getUserId()
    {
        return  this.userId;
    }
    public String getToken()
    {
        return this.accessToken;
    }
    public List<Cookie> getCookies()
    {
        return this.restAssuredCookies;
    }
    public String getFirstName()
    {
        return  this.firstName;
    }
    public void  register()
    {

        User user=UserUtils.generateRandomUser();
        //Given
        Response response=
                given()
                   .baseUri("http://qacart-todo.herokuapp.com")
                   .header("Content-Type","application/json")
                   //Desrilizetion convert from java Object to Json Object
                  .body(user).log().all()
                   //When
                  .when()
                  .post(EndPoint.API_REGISTER_ENDPOINT)
                   //Then
                   .then() .log().all().
                   extract().response();
        if(response.statusCode()!=201)
        {
           throw  new RuntimeException("Something is wrong");
        }

       restAssuredCookies=response.detailedCookies().asList();
          accessToken=response.path("access_token");
          userId=response.path("userID");
        firstName=response.path("firstName");

    }
}
