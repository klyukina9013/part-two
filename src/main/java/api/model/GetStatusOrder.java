package api.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@Getter
@ToString
@JsonRootName(value = "data")

public class GetStatusOrder {

    private String orderStatus;

}
