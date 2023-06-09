package creditProcessing.successful_tests;


import api.model.CreateOrderRequest;
import api.steps.PostSteps;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("API tests")
@Feature("Оформление кредита")
@Story("Метод подачи заявки на кредит")
public class PostApplyTest {

    private final PostSteps postSteps = new PostSteps();

    @Test
    @Description("Подаем заявку на кредит под передаваемымми в запросе userId и tariffId")
    @DisplayName("Успешная подача заявки")
    public void successfulApply(){
        CreateOrderRequest newApplication = new CreateOrderRequest(1101101106L,1);
        Response response = postSteps.applySuccessful(newApplication);
        postSteps.check200(response);
    }

}
