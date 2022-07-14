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
                .genre(request.getGenre())
                .birthDate(request.getBirthDate())
                .cpf(request.getCpf())
                .telephone(request.getTelephone())
                .email(request.getEmail())
                .build();
    }

    public static ClientResponse toResponse(ClientModel model) {
        return ClientResponse
                .builder()
                .id(model.getId())
                .fullName(model.getFullName())
                .genre(model.getGenre())
                .birthDate(model.getBirthDate())
                .cpf(model.getCpf())
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
