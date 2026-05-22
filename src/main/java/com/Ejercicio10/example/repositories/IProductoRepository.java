package com.Ejercicio10.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ejercicio10.example.models.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}

// simplificacion del repositoruy