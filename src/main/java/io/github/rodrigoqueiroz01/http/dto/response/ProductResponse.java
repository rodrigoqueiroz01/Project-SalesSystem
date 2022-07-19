package io.github.rodrigoqueiroz01.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private UUID id;
    private String description;
    private BigDecimal price;
    private Integer quantityStock;

}
