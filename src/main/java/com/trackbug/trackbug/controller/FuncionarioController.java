package com.trackbug.trackbug.controller;

import com.trackbug.trackbug.model.Funcionario;
import com.trackbug.trackbug.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/buscarFuncionario")
    public String buscarFuncionario(@RequestParam(value = "id_funcionario", required = false) Long id, Model model) {
        if (id != null) {
            Optional<Funcionario> funcionarioOptional = funcionarioService.getById(id);
            if (funcionarioOptional.isPresent()) {
                model.addAttribute("funcionario", funcionarioOptional.get());
            } else {
                model.addAttribute("erro", "Funcionário não encontrado com ID: " + id);
            }
        }
        return "buscar_funcionario";  // Nome do arquivo HTML
    }


}
