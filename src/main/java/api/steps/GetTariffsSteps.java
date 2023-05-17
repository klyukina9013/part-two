package api.steps;

import api.model.GetTariffsResponse;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;


public class GetTariffsSteps {
    @Step("Отправляем запрос GET http://localhost:8080/loan-service/getTariffs")
    public static GetTariffsResponse getDescriptionOfTariffs(){
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get("getTariffs")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract().body().jsonPath().getObject("data", GetTariffsResponse.class);

    }

    @Step("Проверяем наличие символа % в поле interestRate в каждом тарифе")
    public void checkPercent(GetTariffsResponse response) {
        Assertions.assertTrue(response.getTariffs().stream().allMatch(x -> x.getInterestRate().contains("%")));
    }



}
