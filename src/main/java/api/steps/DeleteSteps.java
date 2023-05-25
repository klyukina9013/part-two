package api.steps;

import api.constant.OrderStatus;
import api.model.DeleteOrderRequest;
import api.model.Error;
import api.model.GetStatusOrder;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

public class DeleteSteps {

    @Step("Отправить запрос DELETE http://localhost:8081/loan-service/deleteOrder")
    public static Response deleteApply(DeleteOrderRequest delete){
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(delete)
                .delete("deleteOrder")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .response();
    }

    @Step("Отправить запрос DELETE http://localhost:8081/loan-service/deleteOrder")
    public static Response deleteApplyUnsuccessful(DeleteOrderRequest delete){
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(delete)
                .delete("deleteOrder")
                .then()
                .spec(SpecHelper.getResponseSpec(400))
                .extract()
                .response();

    }

    @Step("Проверка статуса кода запроса")
    public void check200del(Response response) {
        int statusCodeOk = response.statusCode();
        Assertions.assertEquals(200, statusCodeOk);
    }

    @Step("Проверка статуса кода запроса")
    public void check400del(Response response) {
        int statusCodeOk = response.statusCode();
        Assertions.assertEquals(400, statusCodeOk);
    }

}
