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

    private LocalDateTime data_hora_saida;
    private LocalDateTime data_hora_retorno;
    @ManyToOne
    private Funcionario funcionario_responsavel;
    @ManyToOne
    private Equipamento equipamento;
    private String observacoes_emprestimo;

    public void setId(long id) {
        this.id = id;
    }

    public void setData_hora_saida(LocalDateTime data_hora_saida) {
        this.data_hora_saida = data_hora_saida;
    }

    public void setData_hora_retorno(LocalDateTime data_hora_retorno) {
        this.data_hora_retorno = data_hora_retorno;
    }

    public void setFuncionario_responsavel(Funcionario funcionario_responsavel) {
        this.funcionario_responsavel = funcionario_responsavel;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public void setObservacoes_emprestimo(String observacoes_emprestimo) {
        this.observacoes_emprestimo = observacoes_emprestimo;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getData_hora_saida() {
        return data_hora_saida;
    }

    public LocalDateTime getData_hora_retorno() {
        return data_hora_retorno;
    }

    public Funcionario getFuncionario_responsavel() {
        return funcionario_responsavel;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public String getObservacoes_emprestimo() {
        return observacoes_emprestimo;
    }
}
