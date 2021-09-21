package test;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Users;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ContractTest extends test.Base {

    @Test
    void Contract() {

        Users params = new Users();
        params.setName(faker.name().firstName());
        params.setJob(faker.job().field());

        resp = given()
                .contentType("application/json")
                .body(params.toString())
                .when()
                .post("/api/users")
                .then()
                .body(matchesJsonSchemaInClasspath("schema.json"))
                .extract().response();
        int statusCode = resp.getStatusCode();
        Assert.assertEquals(statusCode, 201);


    }
}