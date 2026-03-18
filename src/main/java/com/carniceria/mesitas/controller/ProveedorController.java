package com.carniceria.mesitas.controller;
import com.carniceria.mesitas.entity.Proveedor;
import com.carniceria.mesitas.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository repository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("proveedores", repository.findAll());
        return "proveedores/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedores/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proveedor proveedor) {
        repository.save(proveedor);
        return "redirect:/proveedores";
    }
}
