package com.Ejercicio10.example.interfaces;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.Ejercicio10.example.models.Producto;

public interface IProductoService {
    Producto guardar(Producto producto);
    List<Producto> obtenerTodos();
    Page<Producto> obtenerPaginados(Pageable pageable);
}
