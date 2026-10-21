# Aula Maker - Sistema de Gestión de Préstamos (Entrega P3-P4)

Aplicación web desarrollada con **Spring Boot 4 / Spring MVC** y **Thymeleaf** para controlar la solicitud y reserva temporal de recursos técnicos en salas universitarias.

## Cómo ejecutar el proyecto
1. Clonar o descomprimir el proyecto `entregaP3P4`.
2. Ejecutar el comando `./mvnw spring-boot:run` desde la terminal o arrancar la clase principal `EntregaP3P4Application` desde el IDE.
3. Abrir en el navegador la dirección: `http://localhost:8080/`

---

## Decisiones Técnicas y de Arquitectura
- **Controlador Único:** Se ha centralizado la lógica en `AulaMakerController` manteniendo el catálogo como una constante estática en memoria (`String[][]`), evitando sobrecargar la comunicación entre capas.
- **Tipos de Datos Coherentes:** Se utiliza la clase `Integer` (en lugar de `int`) para permitir valores nulos en el binding y capturar el campo vacío mediante `@NotNull`. Las fechas se gestionan con `LocalDate` y la anotación `@DateTimeFormat(iso = ISO.DATE)`.
- **Gestión de Errores Real:** Cuando un recurso no existe, el controlador eleva un código de estado HTTP 404 real mediante `ResponseStatusException`, en lugar de camuflar el fallo en un estado 200 de éxito.

---

## Ámbito y Ciclo de Vida de los Datos (Explicación para Defensa)

### 1. Parámetros de Método
- **Qué son:** Variables que recibe un método del controlador inyectadas directamente por Spring MVC a partir de los datos que viajan en la petición HTTP entrante.
- **Ciclo de vida:** Son efímeros. Existen única y exclusivamente durante la ejecución de esa llamada concreta al método del controlador.
- **Ejemplos en el proyecto:**
    - El código capturado de la URL con `@PathVariable`.
    - El turno opcional capturado con `@RequestParam`.
    - El objeto DTO y su respectivo contenedor de fallos `BindingResult`.

### 2. Variables Locales
- **Qué son:** Variables declaradas dentro del cuerpo de los métodos de Java.
- **Ciclo de vida:** Pertenecen al hilo de ejecución del método. Nacen en su línea de asignación y mueren inmediatamente al llegar a la llave de cierre (`}`) o al ejecutar el `return`. No son accesibles desde fuera.
- **Uso con la Vista:** Si la plantilla Thymeleaf necesita renderizarlas, el controlador está obligado a inyectarlas explícitamente en el objeto `Model`.
- **Ejemplos en el proyecto:** El array temporal `materialEncontrado`, y los primitivos `diasPrestamo` o `diasUnidad`.

### 3. Propiedades del DTO (SolicitudPrestamoForm)
- **Qué son:** Los campos privados o atributos que le dan estructura al formulario de datos.
- **Ciclo de vida:** Viven en el espacio de memoria de la petición actual (`Request Scope`). Spring las instancia vacías en el flujo `GET`, se rellenan mediante la interfaz al hacer `POST`, se evalúan y se destruyen al cambiar de página, dado que la aplicación cumple el requisito de **no persistencia** (sin base de datos).

### 4. Atributos del Modelo y Variables de Vista
- **Qué son:** El mapa de datos (`Model`) que actúa como puente de comunicación estricto entre el backend (Java) y el frontend (Thymeleaf).
- **Ciclo de vida:** El controlador asocia un objeto a una clave string (`model.addAttribute("clave", objeto)`), Thymeleaf lo procesa en el servidor generando el HTML definitivo y, una vez servido el archivo al navegador del usuario, el modelo se limpia por completo.

---

## Limitaciones de la Entrega
- **Sin Persistencia:** La aplicación procesa y valida los datos con éxito en tiempo real, pero el sistema no almacena ni aprueba las solicitudes en bases de datos ni sesiones de usuario.
