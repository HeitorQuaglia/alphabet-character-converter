package com.overengineered.alphabet.infrastructure.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class AlphabetResourceTest {

    @Test
    void shouldReturnLetterForValidPosition() {
        given()
                .when().get("/alphabet/1")
                .then()
                .statusCode(200)
                .body("letter", equalTo("A"));
    }

    @Test
    void shouldReturnBadRequestForZero() {
        given()
                .when().get("/alphabet/0")
                .then()
                .statusCode(400)
                .body("error", containsString("Invalid position"));
    }

    @Test
    void shouldReturnBadRequestForOutOfRange() {
        given()
                .when().get("/alphabet/27")
                .then()
                .statusCode(400)
                .body("error", containsString("Invalid position"));
    }

    @Test
    void shouldReturnBadRequestForNegative() {
        given()
                .when().get("/alphabet/-5")
                .then()
                .statusCode(400)
                .body("error", containsString("Invalid position"));
    }

    @Test
    void shouldReturnLetterZFor26() {
        given()
                .when().get("/alphabet/26")
                .then()
                .statusCode(200)
                .body("letter", equalTo("Z"));
    }
}
