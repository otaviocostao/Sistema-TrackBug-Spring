package com.trackbug.trackbug.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;

    private String descricaoEqp;
    private LocalDateTime dataCompraEqp;
    private double pesoEqp;
    private double larguraEqp;
    private double comprimentoEqp;
    private String historicoManutencaoEqp;
    private String estadoConservacaoEqp;
}
