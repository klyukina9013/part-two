package creditProcessing;

import api.model.CreateOrderRequest;
import api.model.DeleteOrderRequest;
import api.steps.DeleteSteps;
import api.steps.PostSteps;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteOrderTest {

    DeleteSteps deleteSteps = new DeleteSteps();


    @Test
    @Description("Удаляем заявку по передаваемым в методе полям userId и orderId")
    @DisplayName("Успешное удаление пользователя")
    public void successfulDelApply(){
        DeleteOrderRequest delete = new DeleteOrderRequest(Long.valueOf(123456),"62f7f1a6-7581-4f87-811d-202d027e817e" );
        Response responseDel = deleteSteps.deleteApply(delete);
        deleteSteps.check200del(responseDel);
    }

    @Test
    @Description("Удаляем заявку по передаваемым в методе полям userId и orderId")
    @DisplayName("Неуспешное удаление пользователя")
    public void unsuccessfulDelApply(){
        DeleteOrderRequest deleteOrder = new DeleteOrderRequest(Long.valueOf(1234567),"62f7f1a6-7581-4f87-811d-202d027e817e" );
        Response response = deleteSteps.deleteApply(deleteOrder);
        deleteSteps.check400del(response);
    }





}
