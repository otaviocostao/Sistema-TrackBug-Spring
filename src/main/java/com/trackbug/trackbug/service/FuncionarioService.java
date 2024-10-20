package com.trackbug.trackbug.service;

import com.trackbug.trackbug.model.Funcionario;
import com.trackbug.trackbug.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario saveFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getById(Long id){
        return funcionarioRepository.findById(id);
    }

    public Funcionario updateFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }

}
