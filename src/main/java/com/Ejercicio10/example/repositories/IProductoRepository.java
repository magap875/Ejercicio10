package com.Ejercicio10.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.Ejercicio10.example.models.Producto;

@Repository
public interface IProductoRepository extends PagingAndSortingRepository<Producto, Long>, CrudRepository<Producto, Long> {
}
