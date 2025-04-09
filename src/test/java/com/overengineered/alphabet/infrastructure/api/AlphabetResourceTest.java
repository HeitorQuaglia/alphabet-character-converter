package com.overengineered.alphabet.infrastructure.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class AlphabetResourceTest {

    @Test
    void shouldReturnLetterForValidPosition_en() {
        given()
                .header("Accept-Language", "en")
                .when().get("/alphabet/1")
                .then()
                .statusCode(200)
                .body("letter", equalTo("A"));
    }

    @Test
    void shouldReturnLetterForValidPosition_pt() {
        given()
                .header("Accept-Language", "pt-BR")
                .when().get("/alphabet/26")
                .then()
                .statusCode(200)
                .body("letter", equalTo("Z"));
    }

    @Test
    void shouldReturnBadRequestForZero_en() {
        given()
                .header("Accept-Language", "en")
                .when().get("/alphabet/0")
                .then()
                .statusCode(400)
                .body("error", containsString("Invalid position"));
    }

    @Test
    void shouldReturnBadRequestForZero_pt() {
        given()
                .header("Accept-Language", "pt-BR")
                .when().get("/alphabet/0")
                .then()
                .statusCode(400)
                .body("error", containsString("Posição inválida"));
    }

    @Test
    void shouldReturnBadRequestForNegative_en() {
        given()
                .header("Accept-Language", "en")
                .when().get("/alphabet/-5")
                .then()
                .statusCode(400)
                .body("error", containsString("Invalid position"));
    }

    @Test
    void shouldReturnBadRequestForOutOfRange_pt() {
        given()
                .header("Accept-Language", "pt-BR")
                .when().get("/alphabet/27")
                .then()
                .statusCode(400)
                .body("error", containsString("Posição inválida"));
    }
}
