package com.trackbug.trackbug.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Emprestimo {
    @Id
    private long id;

    private LocalDateTime dataHoraSaida;
    private LocalDateTime dataHoraRetorno;
    private Funcionario funcionarioResponsavel;
    private Equipamento equipamento;
    private String observacoesEmprestimo;
}
