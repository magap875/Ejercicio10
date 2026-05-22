package com.Ejercicio10.example.controllers;

import com.Ejercicio10.example.interfaces.IProductoService;
import com.Ejercicio10.example.models.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private IProductoService productoService;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        @DisplayName("crear producto correctamente")
        void guardarProducto() throws Exception {

                Producto producto = Producto.builder()
                                .id(1L)
                                .nombre("Mouse")
                                .precio(1500.0)
                                .stock(10)
                                .build();

                when(productoService.guardar(producto))
                                .thenReturn(producto);

                mockMvc.perform(post("/productos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(producto)))

                                .andExpect(status().isCreated())

                                .andExpect(jsonPath("$.nombre")
                                                .value("Mouse"))

                                .andExpect(jsonPath("$.precio")
                                                .value(1500.0));
        }

        @Test
        @DisplayName("obtener todos los productos")
        void obtenerTodos() throws Exception {

                List<Producto> productos = List.of(
                                Producto.builder()
                                                .id(1L)
                                                .nombre("Mouse")
                                                .precio(1500.0)
                                                .stock(10)
                                                .build(),

                                Producto.builder()
                                                .id(2L)
                                                .nombre("Teclado")
                                                .precio(3000.0)
                                                .stock(5)
                                                .build());

                when(productoService.obtenerTodos())
                                .thenReturn(productos);

                mockMvc.perform(get("/productos"))

                                .andExpect(status().isOk())

                                .andExpect(jsonPath("$.size()")
                                                .value(2))

                                .andExpect(jsonPath("$[0].nombre")
                                                .value("Mouse"));
        }

        @Test
        @DisplayName("rechazar producto sin nombre")
        void rechazarProductoSinNombre() throws Exception {

                Producto producto = Producto.builder()
                                .precio(1500.0)
                                .stock(10)
                                .build();

                mockMvc.perform(post("/productos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(producto)))

                                .andExpect(status().isBadRequest());
        }

        @Test
        @DisplayName("rechazar producto con precio negativo")
        void rechazarProductoConPrecioNegativo() throws Exception {

                Producto producto = Producto.builder()
                                .nombre("Mouse")
                                .precio(-100.0)
                                .stock(10)
                                .build();

                mockMvc.perform(post("/productos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(producto)))

                                .andExpect(status().isBadRequest());
        }
}