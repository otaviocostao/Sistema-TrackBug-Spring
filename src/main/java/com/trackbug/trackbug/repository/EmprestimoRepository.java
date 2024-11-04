package com.trackbug.trackbug.repository;

import com.trackbug.trackbug.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    public List<Emprestimo> findByStatus(String status);
}
