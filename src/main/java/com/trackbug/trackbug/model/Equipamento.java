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
    private String disponibilidade = "Disponível";

    public Long getId_equipamento() {
        return id_equipamento;
    }

    public String getDescricao_eqp() {
        return descricao_eqp;
    }

    public LocalDate getData_compra_eqp() {
        return data_compra_eqp;
    }

    public double getPeso_eqp() {
        return peso_eqp;
    }

    public double getLargura_eqp() {
        return largura_eqp;
    }

    public double getComprimento_eqp() {
        return comprimento_eqp;
    }

    public String getHistorico_manutencao_eqp() {
        return historico_manutencao_eqp;
    }

    public String getEstado_conservacao_eqp() {
        return estado_conservacao_eqp;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setId_equipamento(Long id_equipamento) {
        this.id_equipamento = id_equipamento;
    }

    public void setDescricao_eqp(String descricao_eqp) {
        this.descricao_eqp = descricao_eqp;
    }

    public void setData_compra_eqp(LocalDate data_compra_eqp) {
        this.data_compra_eqp = data_compra_eqp;
    }

    public void setPeso_eqp(double peso_eqp) {
        this.peso_eqp = peso_eqp;
    }

    public void setLargura_eqp(double largura_eqp) {
        this.largura_eqp = largura_eqp;
    }

    public void setComprimento_eqp(double comprimento_eqp) {
        this.comprimento_eqp = comprimento_eqp;
    }

    public void setHistorico_manutencao_eqp(String historico_manutencao_eqp) {
        this.historico_manutencao_eqp = historico_manutencao_eqp;
    }

    public void setEstado_conservacao_eqp(String estado_conservacao_eqp) {
        this.estado_conservacao_eqp = estado_conservacao_eqp;
    }

    public void setDisponibilidade_eqp(String disponibilidade_eqp) {
        this.disponibilidade = disponibilidade_eqp;
    }
}
