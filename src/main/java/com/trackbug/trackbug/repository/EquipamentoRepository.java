package com.trackbug.trackbug.repository;

import com.trackbug.trackbug.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    public List<Equipamento> findByDisponibilidade(String disponibilidade);

    @Query("SELECT COUNT(e) FROM Equipamento e")
    public long countEquipamento();
}
