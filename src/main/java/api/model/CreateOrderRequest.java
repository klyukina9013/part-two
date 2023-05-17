package api.model;


import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@JsonRootName(value = "data")
public class CreateOrderRequest {

    private Long userId;
    private Integer tariffId;
}
