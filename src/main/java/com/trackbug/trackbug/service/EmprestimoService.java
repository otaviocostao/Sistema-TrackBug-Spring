package com.trackbug.trackbug.service;

import com.trackbug.trackbug.model.Emprestimo;
import com.trackbug.trackbug.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo saveEmprestimo(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> findAll(){
        return emprestimoRepository.findAll();
    }

    public Optional<Emprestimo> getById(Long id){
        return emprestimoRepository.findById(id);
    }

    public Emprestimo updateEmprestimo(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }

    public void deleteEmprestimo(Long id){
        emprestimoRepository.deleteById(id);
    }
}
