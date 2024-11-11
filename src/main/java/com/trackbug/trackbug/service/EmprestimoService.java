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

    public List<Emprestimo> listarEmprestimos(String ordem) {
        if ("recentes".equals(ordem)) {
            return emprestimoRepository.findEmprestimosMaisRecentes();
        } else if ("antigos".equals(ordem)) {
            return emprestimoRepository.findEmprestimosMaisAntigos();
        }
        return (List<Emprestimo>) emprestimoRepository.findAll(); // Default sem filtro
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
