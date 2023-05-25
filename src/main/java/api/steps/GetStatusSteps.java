package api.steps;

import api.constant.OrderStatus;
import api.model.Error;
import api.model.GetStatusOrder;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

public class GetStatusSteps {

    @Step("Отправить запрос POST http://localhost:8080/loan-service/getStatusOrder?orderId={orderId}")
    public static GetStatusOrder getStatusSuccessful(String orderId){
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get("getStatusOrder?orderId={orderId}", orderId)
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract().body().jsonPath().getObject("data",GetStatusOrder.class);
    }

    @Step("Отправить запрос POST http://localhost:8080/loan-service/getStatusOrder?orderId={orderId}")
    public static Error getStatusUnsuccessful(String orderId){
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get("getStatusOrder?orderId={orderId}", orderId)
                .then()
                .spec(SpecHelper.getResponseSpec(400))
                .extract().body().jsonPath().getObject("error", Error.class);
    }


    @Step("Проверка значения orderStatus")
    public void checkOrderStatus(GetStatusOrder response) {
        Assertions.assertEquals(OrderStatus.APPROVED.name(), response.getOrderStatus());
    }

    @Step("Проверка значения orderStatus")
    public void checkCode(Error response) {
        Assertions.assertEquals("Заявка не найдена", response.getMessage());
    }



}
