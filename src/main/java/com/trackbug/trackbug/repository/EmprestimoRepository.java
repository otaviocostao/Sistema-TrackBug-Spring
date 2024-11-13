package com.trackbug.trackbug.repository;

import com.trackbug.trackbug.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    public List<Emprestimo> findByStatus(String status);

    @Query("SELECT COUNT(e) FROM Emprestimo e WHERE e.status = 'Ativo'")
    public long countEmprestimos();

    @Query("SELECT e FROM Emprestimo e ORDER BY e.data_hora_saida DESC")
    List<Emprestimo> findEmprestimosMaisRecentes();

    @Query("SELECT e FROM Emprestimo e ORDER BY e.data_hora_saida ASC")
    List<Emprestimo> findEmprestimosMaisAntigos();

    @Query("SELECT e FROM Emprestimo e  WHERE e.status = 'Ativo' AND e.data_hora_retorno < :dataAtual")
    List<Emprestimo> findEmprestimosAtrasados(@Param("dataAtual") LocalDateTime dataAtual);

    @Query("SELECT e FROM Emprestimo e  WHERE e.status = 'Ativo' AND e.data_hora_retorno >= :dataAtual")
    List<Emprestimo> findEmprestimosRegulares(@Param("dataAtual") LocalDateTime dataAtual);
}
