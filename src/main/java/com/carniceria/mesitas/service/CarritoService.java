package com.carniceria.mesitas.service;

import com.carniceria.mesitas.entity.Producto;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope 
public class CarritoService implements Serializable {

    private List<Producto> items = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        items.add(producto);
    }

    public List<Producto> getItems() {
        return items;
    }

    public Double calcularTotal() {
        return items.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public void limpiarCarrito() {
        items.clear();
    }
    
    public int getCantidadItems() {
        return items.size();
    }
}