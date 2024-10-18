package com.trackbug.trackbug.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Funcionario {

    @Id
    private Long idFuncionario;
    private String nomeFuncionario;
    private String funcaoFuncionario;
    private String dataAdmissaoFuncionario;
}
