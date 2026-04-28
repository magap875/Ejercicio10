package com.Ejercicio10.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ejercicio10.example.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
