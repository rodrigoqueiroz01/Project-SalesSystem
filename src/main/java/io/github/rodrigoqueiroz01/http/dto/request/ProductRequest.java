package io.github.rodrigoqueiroz01.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    private String description;
    private BigDecimal price;
    private Integer quantityStock;

}
