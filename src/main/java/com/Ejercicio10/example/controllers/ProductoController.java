package com.Ejercicio10.example.controllers;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import com.Ejercicio10.example.interfaces.IProductoService;
import com.Ejercicio10.example.models.Producto;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {
    private final IProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> guardar(@Valid @RequestBody Producto producto) {
        productoService.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @GetMapping("/paginacion")
    public ResponseEntity<Page<Producto>> obtenerPaginados(
            @RequestParam int page,
            @RequestParam int size) {

        Page<Producto> productos = productoService.obtenerPaginados(
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "precio")));

        return ResponseEntity.ok(productos);
    }
}