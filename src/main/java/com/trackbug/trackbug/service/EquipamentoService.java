package com.trackbug.trackbug.service;

import com.trackbug.trackbug.model.Equipamento;
import com.trackbug.trackbug.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    EquipamentoRepository equipamentoRepository;

    @Autowired
    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public Equipamento saveEquipamento(Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> findAll(){
        return equipamentoRepository.findAll();
    }

    public Optional<Equipamento> getById(Long id){
        return equipamentoRepository.findById(id);
    }

    public Equipamento updateEquipamento(Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }

    public void deleteEquipamento(Long id){
        equipamentoRepository.deleteById(id);
    }
}
