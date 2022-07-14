package io.github.rodrigoqueiroz01.http.mapper;

import io.github.rodrigoqueiroz01.http.dto.request.ClientRequest;
import io.github.rodrigoqueiroz01.http.dto.response.ClientResponse;
import io.github.rodrigoqueiroz01.model.ClientModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ClientMapper {

    public static ClientModel toModel(ClientRequest request) {
        return ClientModel
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

    public static ClientResponse toResponse(ClientModel model) {
        return ClientResponse
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

    public static List<ClientResponse> toResponseList(List<ClientModel> clientModelList) {
        if (isNull(clientModelList) || clientModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return clientModelList
                    .stream()
                    .map(ClientMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
