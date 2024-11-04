package com.trackbug.trackbug.repository;

import com.trackbug.trackbug.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT COUNT(e) FROM Funcionario e")
    public long countFuncionario();
}
