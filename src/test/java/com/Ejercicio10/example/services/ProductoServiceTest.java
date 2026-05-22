package com.Ejercicio10.example.services;

import com.Ejercicio10.example.models.Producto;
import com.Ejercicio10.example.repositories.IProductoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

        @Mock
        private IProductoRepository productoRepository;

        @InjectMocks
        private ProductoServiceImpl productoService;

        @Test
        @DisplayName("registrar producto correctamente")
        void guardarProducto() {

                Producto producto = Producto.builder()
                                .id(1L)
                                .nombre("Mouse")
                                .precio(1500.0)
                                .stock(10)
                                .build();

                when(productoRepository.save(producto))
                                .thenReturn(producto);

                Producto resultado = productoService.guardar(producto);

                assertNotNull(resultado);

                assertEquals(
                                "Mouse",
                                resultado.getNombre());

                verify(productoRepository, times(1))
                                .save(producto);
        }

        @Test
        @DisplayName("obtener todos los productos")
        void obtenerTodos() {

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

                when(productoRepository.findAll())
                                .thenReturn(productos);

                List<Producto> resultado = productoService.obtenerTodos();

                assertNotNull(resultado);

                assertEquals(
                                2,
                                resultado.size());

                verify(productoRepository, times(1))
                                .findAll();
        }

        @Test
        @DisplayName("obtener productos paginados")
        void obtenerPaginados() {

                Pageable pageable = PageRequest.of(0, 5);

                List<Producto> productos = List.of(
                                Producto.builder()
                                                .id(1L)
                                                .nombre("Mouse")
                                                .precio(1500.0)
                                                .stock(10)
                                                .build());

                Page<Producto> pagina = new PageImpl<>(productos);

                when(productoRepository.findAll(pageable))
                                .thenReturn(pagina);

                Page<Producto> resultado = productoService.obtenerPaginados(pageable);

                assertNotNull(resultado);

                assertEquals(
                                1,
                                resultado.getContent().size());

                verify(productoRepository, times(1))
                                .findAll(pageable);
        }
}