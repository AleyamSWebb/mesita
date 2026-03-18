package com.carniceria.mesitas.service;

import com.carniceria.mesitas.entity.Producto;
import com.carniceria.mesitas.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    // 1. Listar todos los productos
    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    // 2. Guardar un producto nuevo o editado
    public void guardar(Producto producto) {
        repository.save(producto);
    }

    // 3. Buscar un producto por su ID (para editarlo)
    public Producto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 4. Eliminar un producto
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}