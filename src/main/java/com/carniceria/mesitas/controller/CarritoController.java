package com.carniceria.mesitas.controller;

import com.carniceria.mesitas.entity.Producto;
import com.carniceria.mesitas.service.ProductoService;
import com.carniceria.mesitas.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private ProductoService productoService;

    // 1. Agregar producto al carrito
    @GetMapping("/agregar/{id}")
    public String agregarAlCarrito(@PathVariable Long id) {
        Producto producto = productoService.buscarPorId(id);
        if (producto != null) {
            carritoService.agregarProducto(producto);
        }
        // Ajusta esta ruta si tu lista de productos está en otra URL
        return "redirect:/productos"; 
    }

    // 2. Ver el carrito
    @GetMapping("/ver")
    public String verCarrito(Model model) {
        model.addAttribute("items", carritoService.getItems());
        model.addAttribute("total", carritoService.calcularTotal());
        
      
        return "productos/carrito"; 
    }
}