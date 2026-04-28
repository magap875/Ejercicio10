package com.Ejercicio10.example.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.Ejercicio10.example.interfaces.IProductoService;
import com.Ejercicio10.example.models.Producto;
import com.Ejercicio10.example.repositories.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {
    private ProductoRepository productoRepository;

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerTodos() {
        List<Producto> lista = new ArrayList<>();
        productoRepository.findAll().forEach(lista::add);
        return lista;
    }
}
