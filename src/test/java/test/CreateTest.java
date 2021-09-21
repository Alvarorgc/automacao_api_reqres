package test;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Users;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class CreateTest extends test.Base {

    @Test
    void create() {

        Users params = new Users();
        params.setName(faker.name().firstName());
        params.setJob(faker.job().field());

        resp = given()
                .contentType("application/json")
                .body(params.toString())
                .when()
                .post("/api/users")
                .then()
                .body("name", is(params.getName())).and()
                .body("job", is(params.getJob())).and()
                .body(containsString("id")).and()
                .body(containsString("createdAt"))
                .extract().response();
        int statusCode = resp.getStatusCode();
        Assert.assertEquals(statusCode, 201);


    }
}