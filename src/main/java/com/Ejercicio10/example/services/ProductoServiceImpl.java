package com.Ejercicio10.example.services;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Ejercicio10.example.interfaces.IProductoService;
import com.Ejercicio10.example.models.Producto;
import com.Ejercicio10.example.repositories.IProductoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {
    private IProductoRepository productoRepository;

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

    @Override
    public Page<Producto> obtenerPaginados(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }
}
