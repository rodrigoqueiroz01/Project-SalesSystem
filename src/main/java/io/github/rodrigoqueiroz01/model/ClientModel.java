package io.github.rodrigoqueiroz01.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client", schema = "public")
public class ClientModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    private String cpf;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "zip_code")
    private String zipCode;

    private String address;

    private Integer number;

    private String district;

    private String telephone;

    private String email;

}
