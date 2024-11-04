package com.trackbug.trackbug.controller;

import com.trackbug.trackbug.service.EmprestimoService;
import com.trackbug.trackbug.service.EquipamentoService;
import com.trackbug.trackbug.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    EquipamentoService equipamentoService;

    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping("/")
    public String paginaHome(Model model){
        long totalFuncionarios = funcionarioService.countFuncionarios();
        model.addAttribute("countFuncionario", totalFuncionarios);

        long totalEquipamentos = equipamentoService.countEquipamento();
        model.addAttribute("countEquipamento", totalEquipamentos);

        long totalEmprestimos = emprestimoService.countEmprestimos();
        model.addAttribute("countEmprestimo", totalEmprestimos);
        return "index";
    }


}
