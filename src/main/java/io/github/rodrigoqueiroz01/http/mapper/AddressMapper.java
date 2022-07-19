package io.github.rodrigoqueiroz01.http.mapper;

import io.github.rodrigoqueiroz01.http.dto.request.AddressRequest;
import io.github.rodrigoqueiroz01.http.dto.response.AddressResponse;
import io.github.rodrigoqueiroz01.model.AddresModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class AddressMapper {

    public static AddresModel toModel(AddressRequest request) {
        return AddresModel
                .builder()
                .zipCode(request.getZipCode())
                .address(request.getAddress())
                .number(request.getNumber())
                .district(request.getDistrict())
                .build();
    }

    public static AddressResponse toResponse(AddresModel model) {
        return AddressResponse
                .builder()
                .id(model.getId())
                .zipCode(model.getZipCode())
                .address(model.getAddress())
                .number(model.getNumber())
                .district(model.getDistrict())
                .build();
    }

    public static List<AddressResponse> toResponseList(List<AddresModel> addresModelList) {
        if (isNull(addresModelList) || addresModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return addresModelList
                    .stream()
                    .map(AddressMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
