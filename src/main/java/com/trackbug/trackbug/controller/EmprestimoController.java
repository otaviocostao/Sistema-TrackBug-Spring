package com.trackbug.trackbug.controller;

import com.trackbug.trackbug.model.Emprestimo;
import com.trackbug.trackbug.model.Equipamento;
import com.trackbug.trackbug.model.Funcionario;
import com.trackbug.trackbug.service.EmprestimoService;
import com.trackbug.trackbug.service.EquipamentoService;
import com.trackbug.trackbug.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping("/listarEmprestimos")
    public String listarEmprestimos(Model model){
        model.addAttribute("emprestimos", emprestimoService.findAll());
        return "listar_emprestimo";
    }

    @GetMapping("/novoEmprestimo")
    public String novoEmprestimo(Model model){
        // Lista de Equipamentos para o select do html:
        List<Equipamento> equipamentos = equipamentoService.findAll();
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
        emprestimo.setEquipamento(equipamento);
        emprestimoService.saveEmprestimo(emprestimo);

        return "redirect:/listarEmprestimos";
    }


}
