package com.trackbug.trackbug.controller;

import com.trackbug.trackbug.model.Funcionario;
import com.trackbug.trackbug.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/listarFuncionarios")
    public String listarFuncionarios(Model model){
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "listar_funcion";
    }

    @GetMapping("/cadastraFuncionario")
    public String cadastraFuncionario(Model model){
        model.addAttribute("funcionario", new Funcionario());
        return "cad_funcionario";
    }

    @PostMapping("/salvarFuncionario")
    public String salvarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario){
        funcionarioService.saveFuncionario(funcionario);
        return "redirect:/listarFuncionarios";
    }

    @GetMapping("/editarFuncionario/{id}")
    public String editarFuncionario(@PathVariable("id") Long id, Model model){
        Funcionario funcionario = funcionarioService.getById(id).orElseThrow(()-> new RuntimeException("Funcionario não encontrado com ID: " + id));

        model.addAttribute("funcionario", funcionario);
        return "editar_funcionario";
    }

    @PostMapping("/salvarEdicaoFuncionario")
    public String salvarEdicaoFuncionario(@ModelAttribute("funcionario") Funcionario funcionario){
        funcionarioService.updateFuncionario(funcionario);
        return "redirect:/listarFuncionarios";
    }

    @PostMapping("/deletarFuncionario/{id}")
    public String deletarFuncionario(@PathVariable("id") Long id){
        funcionarioService.deleteFuncionario(id);
        return "redirect:/listarFuncionarios";
    }


}
