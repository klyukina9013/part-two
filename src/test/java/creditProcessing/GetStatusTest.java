package creditProcessing;

import api.model.Error;
import api.model.GetStatusOrder;
import api.steps.GetStatusSteps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/testData/IncorrectOrderId.csv", numLinesToSkip = 1)
    @Description("Получаем статус заявки, передавая значение поля orderId = {0}")
    @DisplayName("Неуспешное получение статуса заявки")
    public void unsuccessfulCheckStatus(String orderId) {
        Error response = getStatusSteps.getStatusUnsuccessful(orderId);
        getStatusSteps.checkCode(response);
    }
}
