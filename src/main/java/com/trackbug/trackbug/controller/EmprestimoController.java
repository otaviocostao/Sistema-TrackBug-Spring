package com.trackbug.trackbug.controller;

import com.trackbug.trackbug.model.Emprestimo;
import com.trackbug.trackbug.model.Equipamento;
import com.trackbug.trackbug.model.Funcionario;
import com.trackbug.trackbug.service.EmprestimoService;
import com.trackbug.trackbug.service.EquipamentoService;
import com.trackbug.trackbug.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping("/listarEmprestimos")
    public String listarEmprestimos(
            @RequestParam(value = "ordem", required = false) String ordem,
            @RequestParam(value = "status", required = false) String status,
            Model model) {

        List<Emprestimo> emprestimos = emprestimoService.listarEmprestimos(ordem, status);
        model.addAttribute("emprestimos", emprestimos);
        return "listar_emprestimo";
    }


    @GetMapping("/novoEmprestimo")
    public String novoEmprestimo(Model model){
        // Lista de Equipamentos para o select do html:
        List<Equipamento> equipamentos = equipamentoService.findEquipamentosDisponiveis();
        model.addAttribute("equipamentos", equipamentos);
        // Lista de funcionarios para o select do html:
        List<Funcionario> funcionarios = funcionarioService.findAll();
        model.addAttribute("funcionarios", funcionarios);

        // Objeto "emprestimo" para a manipulação no html:
        model.addAttribute("emprestimo", new Emprestimo());
        return "novo_emprestimo";
    }

    @PostMapping("/salvarEmprestimo")
    public String salvarEmprestimo(
            @ModelAttribute("emprestimo") Emprestimo emprestimo,
            @RequestParam(name = "id_funcionario", required = false) Long id_funcionario,
            @RequestParam(name = "id_equipamento", required = false) Long id_equipamento
    ) {
        if (id_funcionario == null || id_equipamento == null) {
            throw new RuntimeException("Parâmetro ausente: id_funcionario ou id_equipamento não está presente.");
        }

        Funcionario funcionario = funcionarioService.getById(id_funcionario)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado com ID: " + id_funcionario));
        Equipamento equipamento = equipamentoService.getById(id_equipamento)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado com ID: " + id_equipamento));

        emprestimo.setFuncionario_responsavel(funcionario);
        equipamento.setDisponibilidade_eqp("Indisponível");
        equipamentoService.updateEquipamento(equipamento);
        emprestimo.setEquipamento(equipamento);

        emprestimoService.saveEmprestimo(emprestimo);


        return "redirect:/listarEmprestimos";
    }


    @GetMapping("/editarEmprestimo/{id}")
    public String editarEmprestimo(@PathVariable("id") Long id, Model model){
        Emprestimo emprestimo = emprestimoService.getById(id).orElseThrow(()-> new RuntimeException("Emprestimo não encontrado com ID: " + id));

        model.addAttribute("emprestimo", emprestimo);
        return "editar_emprestimo";
    }

    @PostMapping("/salvarEdicaoEmprestimo")
    public String salvarEdicaoEmprestimo(@ModelAttribute("emprestimo") Emprestimo emprestimo){

        emprestimoService.updateEmprestimo(emprestimo);
        return "redirect:/listarEmprestimos";
    }

    @PostMapping("/deletarEmprestimo/{id}")
    public String deletarEmprestimo(@PathVariable("id") Long id){
        Emprestimo emprestimo = emprestimoService.getById(id).orElseThrow(()-> new RuntimeException("Emprestimo não encontrado com ID: " + id));
        Equipamento equipamento = emprestimo.getEquipamento();
        equipamento.setDisponibilidade_eqp("Disponível");
        equipamentoService.saveEquipamento(equipamento);

        emprestimoService.deleteEmprestimo(id);
        return "redirect:/listarEmprestimos";
    }

    @PostMapping("/finalizarEmprestimo/{id}")
    public String finalizarEmprestimo(@PathVariable("id") Long id){
        Emprestimo emprestimo = emprestimoService.getById(id).orElseThrow(()-> new RuntimeException("Emprestimo não encontrado com ID: " + id));

        emprestimo.setStatus("Finalizado");
        LocalDateTime data_devolucao = LocalDateTime.now();
        emprestimo.setData_devolucao(data_devolucao);

        Equipamento equipamento = emprestimo.getEquipamento();
        equipamento.setDisponibilidade_eqp("Disponível");
        equipamentoService.saveEquipamento(equipamento);

        emprestimoService.saveEmprestimo(emprestimo);

        return "redirect:/listarEmprestimos";
    }


    @GetMapping("/historicoEmprestimos")
    public String historicoEmprestimos(Model model){
        model.addAttribute("emprestimos", emprestimoService.findEmprestimosFinalizado());
        return "historico_emprestimo";
    }

    @GetMapping("/buscarEmprestimo")
    public String buscarEmprestimo(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id != null) {
            Optional<Emprestimo> emprestimoOptional = emprestimoService.getById(id);
            if (emprestimoOptional.isPresent()) {
                model.addAttribute("emprestimo", emprestimoOptional.get());
            } else {
                model.addAttribute("erro", "Empréstimo não encontrado com ID: " + id);
            }
        }
        return "buscar_emprestimo";  // Nome do arquivo HTML
    }
}
