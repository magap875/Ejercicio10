Gestión de productos

1
Escenario: Registrar un producto correctamente
Dado un producto con nombre "Mouse", precio 1500 y stock 10
Cuando el usuario registra el producto
Entonces el sistema debe guardar el producto correctamente

2
Escenario: Obtener todos los productos
Dado que existen productos registrados
Cuando el usuario consulta la lista de productos
Entonces el sistema debe devolver todos los productos registrados

3
Escenario: Obtener productos paginados
Dado que existen múltiples productos registrados
Cuando el usuario solicita la página 0 con tamaño 5
Entonces el sistema debe devolver los productos ordenados por precio descendente

4
Escenario: Crear producto mediante el endpoint POST
Dado un producto válido
Cuando el cliente envía una petición POST a "/productos"
Entonces el sistema debe responder con código 201 CREATED

5
Escenario: Registrar producto sin nombre
Dado un producto con nombre vacío
Cuando el cliente intenta registrarlo
Entonces el sistema debe responder con código 400 BAD REQUEST

6
Escenario: Registrar producto con precio negativo
Dado un producto con precio negativo
Cuando el cliente intenta registrarlo
Entonces el sistema debe responder con código 400 BAD REQUEST