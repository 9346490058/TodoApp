package com.qacart.com.testcases;


import com.qacart.com.objects.Api.RegisterApi;

public class Dummy {

    public static void main(String[] args) {
        RegisterApi registerApi=new RegisterApi() ;
        registerApi.register();

        System.out.println(registerApi.getToken());
        System.out.println(registerApi.getUserId());
        System.out.println(registerApi.getFirstName());

    }
}
