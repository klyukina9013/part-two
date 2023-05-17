package api.steps;

import api.model.CreateOrderRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class PostSteps {

    @Step("Отправить запрос POST http://localhost:8080/loan-service/order")
    public static Response applySuccessful(CreateOrderRequest newApplication){
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(newApplication)
                .post("order")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .response();
    }

    @Step("Отправить запрос POST http://localhost:8080/loan-service/order")
    public static Response applyUnsuccessful(CreateOrderRequest newApplication){
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(newApplication)
                .post("order")
                .then()
                .spec(SpecHelper.getResponseSpec(400))
                .extract()
                .response();
    }

    @Step("Проверка статуса кода запроса")
    public void check200(Response response) {
        int statusCodeOK = response.statusCode();
        Assertions.assertEquals(200, statusCodeOK);
    }

    @Step("Проверка статуса кода запроса")
    public void check400(Response response) {
        int statusCode = response.statusCode();
        Assertions.assertEquals(400, statusCode);
    }


}
