package creditProcessing.successful_tests;

import api.model.GetTariffsResponse;
import api.steps.GetTariffsSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Epic("API tests")
@Feature("Оформление кредита")
@Story("Метод получения тарифов")
@DisplayName("Метод получения тарифов")
public class GetTariffsTest {

    private final GetTariffsSteps getTariffsSteps = new GetTariffsSteps();

    @Description("Получаем список всех тарифов и их параметров")
    @DisplayName("Получение списка тарифов")
    @Test
    public void getTariffsList(){
        GetTariffsResponse response = getTariffsSteps.getDescriptionOfTariffs();
        getTariffsSteps.checkPercent(response);
    }


}
