package creditProcessing.successful_tests;

import api.model.Error;
import api.model.GetStatusOrder;
import api.steps.GetStatusSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


@Epic("API tests")
@Feature("Оформление кредита")
@Story("Метод получения статуса заявки")
@DisplayName("Метод получения статуса заявки")
public class GetStatusTest {

    GetStatusSteps getStatusSteps = new GetStatusSteps();

    @ParameterizedTest
    @CsvFileSource(resources = "/testData/CorrectOrderId.csv", numLinesToSkip = 1)
    @Description("Получаем статус заявки, передавая значение поля orderId = {0}")
    @DisplayName("Успешное получение статуса заявки")
    public void successfulCheckStatus(String orderId) {
        GetStatusOrder response = getStatusSteps.getStatusSuccessful(orderId);
        getStatusSteps.checkOrderStatus(response);
    }

}
