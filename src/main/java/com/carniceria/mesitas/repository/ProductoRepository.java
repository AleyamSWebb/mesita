package com.carniceria.mesitas.repository;

import com.carniceria.mesitas.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // JpaRepository ya trae listos los métodos para guardar, eliminar y buscar.
}
