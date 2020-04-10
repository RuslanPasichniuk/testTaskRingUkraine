package com.example.controllers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DiceRollerController {
    private RequestSpecification requestSpecification;

    public DiceRollerController() {
        requestSpecification = new RequestSpecBuilder()
                .setPort(8888)
                .setBaseUri("http://localhost/")
                .log(LogDetail.ALL).build();
        new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectResponseTime(Matchers.lessThan(15000L))
                .build();
    }

    public List<String> roleDice(Integer dices, Integer faces, long rolls) {
        return Arrays.asList(given(requestSpecification)
                .queryParam("dices", dices)
                .queryParam("faces", faces)
                .queryParam("rolls", rolls)
                .when().get("api/roll")
                .then().statusCode(200)
                .and().extract().response().getBody().asString().split("\\n"));
    }
}
