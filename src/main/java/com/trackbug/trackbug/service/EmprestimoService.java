package com.trackbug.trackbug.service;

import com.trackbug.trackbug.model.Emprestimo;
import com.trackbug.trackbug.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<Emprestimo> listarEmprestimos(String ordem, String status) {
        LocalDateTime hoje = LocalDateTime.now();
        List<Emprestimo> emprestimos;

        // Filtragem por ordem
        if ("recentes".equals(ordem)) {
            emprestimos = emprestimoRepository.findEmprestimosMaisRecentes();
        } else if ("antigos".equals(ordem)) {
            emprestimos = emprestimoRepository.findEmprestimosMaisAntigos();
        } else {
            emprestimos = emprestimoRepository.findAll();
        }

        // Filtragem por status usando SQL diretamente
        if ("atrasado".equals(status)) {
            emprestimos = emprestimoRepository.findEmprestimosAtrasados(hoje);
        } else if ("regular".equals(status)) {
            emprestimos = emprestimoRepository.findEmprestimosRegulares(hoje);
        } else if ("todos".equals(status)) {
            emprestimos = emprestimoRepository.findAll();
        }

        return emprestimos;
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

    public List<Emprestimo> findEmprestimosAtivos(){
        return emprestimoRepository.findByStatus("Ativo");
    }
    public List<Emprestimo> findEmprestimosFinalizado(){
        return emprestimoRepository.findByStatus("Finalizado");
    }

    public long countEmprestimos(){
        return emprestimoRepository.countEmprestimos();
    }


}
