package com.trackbug.trackbug.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

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
    private Long id_equipamento;

    private String descricao_eqp;
    private LocalDate data_compra_eqp;
    private double peso_eqp;
    private double largura_eqp;
    private double comprimento_eqp;
    private String historico_manutencao_eqp;
    private String estado_conservacao_eqp;
    private String disponibilidade_eqp = "Disponível";
}
