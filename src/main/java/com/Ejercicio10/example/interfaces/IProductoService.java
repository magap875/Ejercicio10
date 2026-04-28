package com.Ejercicio10.example.interfaces;

import java.util.List;

import com.Ejercicio10.example.models.Producto;

public interface IProductoService {
    Producto guardar(Producto producto);
    List<Producto> obtenerTodos();
}
