package com.trackbug.trackbug.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime dataHoraSaida;
    private LocalDateTime dataHoraRetorno;
    @ManyToOne
    private Funcionario funcionarioResponsavel;
    @ManyToOne
    private Equipamento equipamento;
    private String observacoesEmprestimo;
}
