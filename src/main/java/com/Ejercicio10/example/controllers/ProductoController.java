package com.Ejercicio10.example.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Ejercicio10.example.interfaces.IProductoService;
import com.Ejercicio10.example.models.Producto;

import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {
    private final IProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        productoService.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }
}