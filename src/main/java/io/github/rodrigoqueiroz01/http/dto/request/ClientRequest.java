package io.github.rodrigoqueiroz01.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientRequest {

    @NotNull(message = "O nome do cliente não foi informado.")
    private String fullName;

    private String genre;

    @NotNull(message = "A data de nascimento não foi informada.")
    private String birthDate;

    @NotNull(message = "O CPF não foi informado.")
    private String cpf;

    @NotNull(message = "O telefone não foi informado.")
    private String telephone;

    @NotNull(message = "O email não foi informado.")
    private String email;

}
