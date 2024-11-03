package com.trackbug.trackbug.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_funcionario;
    
    private String nome_funcionario;
    private String funcao_funcionario;
    private String data_admissao_funcionario;

    public Long getId_funcionario() {
        return id_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public String getFuncao_funcionario() {
        return funcao_funcionario;
    }

    public String getData_admissao_funcionario() {
        return data_admissao_funcionario;
    }

    public void setId_funcionario(Long id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public void setFuncao_funcionario(String funcao_funcionario) {
        this.funcao_funcionario = funcao_funcionario;
    }

    public void setData_admissao_funcionario(String data_admissao_funcionario) {
        this.data_admissao_funcionario = data_admissao_funcionario;
    }
}
