package com.carniceria.mesitas.controller;
import com.carniceria.mesitas.entity.Cliente;
import com.carniceria.mesitas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", repository.findAll());
        return "clientes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente cliente) {
        repository.save(cliente);
        return "redirect:/clientes";
    }
}
