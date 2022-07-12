package io.github.rodrigoqueiroz01.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientRetailRequest {

    @NotNull(message = "O nome do cliente não foi informado.")
    private String fullName;

    @NotNull(message = "O CPF do cliente não foi informado.")
    private String cpf;

    @NotNull(message = "A data de nascimento do cliente não foi informado.")
    private String birthDate;

    @NotNull(message = "O CEP do cliente não foi encontrado.")
    private String zipCode;

    @NotNull(message = "O endereço do cliente não foi informado.")
    private String address;

    @NotNull(message = "O número não foi informado.")
    private Integer number;

    @NotNull(message = "O bairro não foi informado.")
    private String district;

    @NotNull(message = "O telefone do cliente não foi informado.")
    private String telephone;

    @NotNull(message = "O email do cliente não foi informado.")
    private String email;

}
