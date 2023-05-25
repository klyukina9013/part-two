package creditProcessing.successful_tests;

import api.model.DeleteOrderRequest;
import api.steps.DeleteSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("API tests")
@Feature("Оформление кредита")
@Story("Метод удаления заявки")

public class DeleteOrderTest {

    DeleteSteps deleteSteps = new DeleteSteps();

    @Test
    @Description("Удаляем заявку по передаваемым в методе полям userId и orderId")
    @DisplayName("Успешное удаление пользователя")
    public void successfulDelApply(){
        DeleteOrderRequest delete = new DeleteOrderRequest(1101101106L,"346ad097-5098-4add-9691-58aaa8771cd5");
        Response responseDel = deleteSteps.deleteApply(delete);
        deleteSteps.check200del(responseDel);
    }

}
