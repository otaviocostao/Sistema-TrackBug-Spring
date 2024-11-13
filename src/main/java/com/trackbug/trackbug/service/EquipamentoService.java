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

    public List<Equipamento> findAll(String disponibilidade){
        List<Equipamento> equipamentos;

        if("disponivel".equals(disponibilidade)){
            equipamentos = findEquipamentosDisponiveis();
        }else if( "indisponivel".equals(disponibilidade)){
            equipamentos = findEquipamentosIndisponiveis();
        }else if("todos".equals(disponibilidade)){
            equipamentos = equipamentoRepository.findAll();
        }else{
            equipamentos = equipamentoRepository.findAll();
        }
        return equipamentos;
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

    public List<Equipamento> findEquipamentosDisponiveis(){
        return equipamentoRepository.findByDisponibilidade("Disponível");
    }
    public List<Equipamento> findEquipamentosIndisponiveis(){
        return equipamentoRepository.findByDisponibilidade("Indisponível");
    }

    public long countEquipamento(){
        return equipamentoRepository.countEquipamento();
    }
}
