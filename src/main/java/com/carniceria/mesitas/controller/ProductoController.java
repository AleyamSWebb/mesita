package com.carniceria.mesitas.controller;

import com.carniceria.mesitas.entity.Producto;
import com.carniceria.mesitas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    // Mostrar la lista de productos
    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", service.listarTodos());
        return "productos/lista";
    }

    // Mostrar el formulario para crear un producto nuevo
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/formulario";
    }

    // Guardar el producto en la base de datos
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        service.guardar(producto);
        return "redirect:/productos";
    }

    // Mostrar el formulario para editar
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", service.buscarPorId(id));
        return "productos/formulario";
    }

    // Eliminar un producto
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/productos";
    }
}