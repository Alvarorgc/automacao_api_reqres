package test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import java.util.Locale;

public class Base {

    public Faker faker = new Faker(new Locale("pt-BR"));
    public static Response resp;

    @BeforeTest
    public static void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = "https://reqres.in/";

    }

}
