package io.github.rodrigoqueiroz01.http.mapper;

import io.github.rodrigoqueiroz01.http.dto.request.ClientRetailRequest;
import io.github.rodrigoqueiroz01.http.dto.response.ClientRetailResponse;
import io.github.rodrigoqueiroz01.model.ClientRetailModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class ClientRetailMapper {

    public static ClientRetailModel toModel(ClientRetailRequest request) {
        return ClientRetailModel
                .builder()
                .fullName(request.getFullName())
                .cpf(request.getCpf())
                .birthDate(request.getBirthDate())
                .zipCode(request.getZipCode())
                .address(request.getAddress())
                .number(request.getNumber())
                .district(request.getDistrict())
                .telephone(request.getTelephone())
                .email(request.getEmail())
                .build();
    }

    public static ClientRetailResponse toResponse(ClientRetailModel model) {
        return ClientRetailResponse
                .builder()
                .id(model.getId())
                .fullName(model.getFullName())
                .cpf(model.getCpf())
                .birthDate(model.getBirthDate())
                .zipCode(model.getZipCode())
                .address(model.getAddress())
                .number(model.getNumber())
                .district(model.getDistrict())
                .telephone(model.getTelephone())
                .email(model.getEmail())
                .build();
    }

    public static List<ClientRetailResponse> toResponseList(List<ClientRetailModel> clientRetailModelList) {
        if (isNull(clientRetailModelList) || clientRetailModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return clientRetailModelList
                    .stream()
                    .map(ClientRetailMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
