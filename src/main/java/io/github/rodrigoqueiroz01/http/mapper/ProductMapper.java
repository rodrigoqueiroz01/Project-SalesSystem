package io.github.rodrigoqueiroz01.http.mapper;

import io.github.rodrigoqueiroz01.http.dto.request.ProductRequest;
import io.github.rodrigoqueiroz01.http.dto.response.ProductResponse;
import io.github.rodrigoqueiroz01.model.ProductModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ProductMapper {

    public static ProductModel toModel(ProductRequest request) {
        return ProductModel
                .builder()
                .description(request.getDescription())
                .price(request.getPrice())
                .quantityStock(request.getQuantityStock())
                .build();
    }

    public static ProductResponse toResponse(ProductModel model) {
        return ProductResponse
                .builder()
                .id(model.getId())
                .description(model.getDescription())
                .price(model.getPrice())
                .quantityStock(model.getQuantityStock())
                .build();
    }

    public static List<ProductResponse> toResponseList(List<ProductModel> productModelList) {
        if (isNull(productModelList) || productModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return productModelList
                    .stream()
                    .map(ProductMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
