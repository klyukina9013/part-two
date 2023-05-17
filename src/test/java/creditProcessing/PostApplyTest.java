package creditProcessing;


import api.model.CreateOrderRequest;
import api.steps.PostSteps;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Epic("API tests")
@Feature("Оформление кредита")
@Story("Метод подачи заявки на кредит")
public class PostApplyTest {

    private final PostSteps postSteps = new PostSteps();

    @Test
    @Description("Подаем заявку на кредит под передаваемымми в запросе userId и tariffId")
    @DisplayName("Успешная подача заявки")
    public void successfulApply(){
        CreateOrderRequest newApplication = new CreateOrderRequest(Long.valueOf(12344321),3);
        Response response = postSteps.applySuccessful(newApplication);
        postSteps.check200(response);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData/ApplicationData.csv", numLinesToSkip = 1)
    @Description("Подаем заявку на кредит под передаваемымми в запросе userId и tariffId")
    @DisplayName("Неуспешная подача заявки")
    public void unsuccessfulApply(Long userID , Integer tariffID ){
        CreateOrderRequest newApplication = new CreateOrderRequest(userID, tariffID);
        Response response = postSteps.applyUnsuccessful(newApplication);
        postSteps.check400(response);
    }

}
