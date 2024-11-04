package com.trackbug.trackbug.controller;

import com.trackbug.trackbug.model.Equipamento;
import com.trackbug.trackbug.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EquipamentoController {

    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping("/listarEquipamentos")
    public String listarEquipamentos(Model model){
        model.addAttribute("equipamentos", equipamentoService.findAll());
        return "listar_equipamentos";
    }

    @GetMapping("/cadastraEquipamento")
    public String cadastraEquipamento(Model model){
        model.addAttribute("equipamento", new Equipamento());
        return "cad_equipamento";
    }

    @PostMapping("/salvarEquipamento")
    public String salvarEquipamento(@ModelAttribute("equipamento") Equipamento equipamento){
        equipamentoService.saveEquipamento(equipamento);
        return "redirect:/listarEquipamentos";
    }

    @GetMapping("/editarEquipamento/{id}")
    public String editarEquipamento(@PathVariable("id") Long id, Model model){
        Equipamento equipamento =  equipamentoService.getById(id).orElseThrow(() -> new RuntimeException("Equipamento não encontrado com ID: " + id));
        model.addAttribute("equipamento", equipamento);
        return "editar_equipamento";
    }

    @PostMapping("/salvarEdicaoEquipamento")
    public String salvarEdicaoEquipamento(@ModelAttribute("equipamento") Equipamento equipamento){
        equipamentoService.updateEquipamento(equipamento);
        return "redirect:/listarEquipamentos";
    }

    @PostMapping("/deletarEquipamento/{id}")
    public String deletarEquipamento(@PathVariable("id") Long id){
        equipamentoService.deleteEquipamento(id);

        return "redirect:/listarEquipamentos";
    }
}
