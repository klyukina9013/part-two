package creditProcessing;

import api.model.GetTariffsResponse;
import api.model.Tariff;
import api.steps.GetTariffsSteps;
import api.steps.SpecHelper;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("API tests")
@Feature("Оформление кредита")
@Story("Метод получения тарифов")

class GetTariffsTest {

    private final GetTariffsSteps getTariffsSteps = new GetTariffsSteps();

    @Description("Получаем список всех тарифов и их параметров")
    @DisplayName("Получение списка тарифов")
    @Test
    void getTariffsList(){
        GetTariffsResponse response = getTariffsSteps.getDescriptionOfTariffs();
        getTariffsSteps.checkPercent(response);
    }


}
