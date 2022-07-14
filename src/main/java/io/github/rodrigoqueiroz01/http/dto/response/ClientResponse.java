package io.github.rodrigoqueiroz01.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    private UUID id;

    private String fullName;

    private String cpf;

    private String birthDate;

    private String zipCode;

    private String address;

    private Integer number;

    private String district;

    private String telephone;

    private String email;

}
