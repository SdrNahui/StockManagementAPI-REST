# StockManagement API REST

Proyecto personal y autodidacta de **API REST** desarrollado con **Spring Boot**, orientado a la gestión de stock.

El objetivo principal es practicar el desarrollo backend con Java, profundizando cómo interactúan una API, la persistencia de datos y las herramientas del ecosistema Spring.
Permite gestionar un stock con endpoints CRUD.
---

## Objetivo del proyecto

* Profundizar qué es y cómo funciona una **API REST**
* Aprender el flujo completo **Controller → Service → Repository**
* Implementar **persistencia con base de datos relacional**
* Utilizar **Spring Boot + Spring Data JPA**
* Probar endpoints usando **Postman**
* Aplicar buenas prácticas básicas de backend

---

## Tecnologías utilizadas

* **Java 17+** (probado con JDK 25.0.1)
* **Spring Boot** (v4.0.2)
* **Spring Web**
* **Spring Data JPA**
* **MySQL** (gestionado con phpMyAdmin / XAMPP)
* **Maven**
* **Postman** (testing de endpoints)

---

## Arquitectura

Arquitectura en capas (Controller -> Service -> Repository -> Model) siguiendo buenas prácticas de Spring:

### Controller

* Exposición de endpoints REST
* Manejo de requests y responses HTTP

### Service

* Lógica de negocio
* Validaciones
* Orquestación de operaciones

### Repository

* Acceso a datos
* Persistencia mediante **JPA**

### Model / Entity

* Entidades mapeadas a la base de datos:
  
#### Product
- id
- name
- description
- stockActual
- price

#### StockMovement
- id
- stockMovementType
- amount
- date
- reason

---

## Endpoints principales

### Productos

| Método | Endpoint                | Descripción                                 |
|--------|-------------------------|---------------------------------------------|
| GET    | /api/products           | Obtener todas los productos                 |
| GET    | /api/products/{id}      | Obtener productos por ID                    |
| POST   | /api/products           | Crear nuevo producto                        |
| PUT    | /api/products/{id}      | Actualizar un producto                      |
| DELETE | /api/products/{id}      | Eliminar un producto                        |

### Movimientos del stock

| Método | Endpoint                | Descripción                                 |
|--------|-------------------------|---------------------------------------------|
| GET    | /api/stock              | Obtener todos los movimientos               |
| GET    | /api/stock/product/{id} | Obtener todos los movimientos por producto  |
| POST   | /api/stock/add          | añade un nuevo movimiento de entrada        |
| POST   | /api/stock/remove       | añade un nuevo movimiento de salida         |
| POST   | /api/stock/adjust       | ajusta la cantidad de stock de forma manual |

---

## Persistencia

* Base de datos **MySQL**
* Mapeo ORM con **JPA / Hibernate**
* Configuración mediante archivos `application.properties`
* Uso de perfiles (`local`) para proteger credenciales

---

## Testing

* Pruebas manuales de la API realizadas con **Postman**
* Verificación de:

  * Creación de productos
  * Obtención de productos
  * Actualización de productos
  * Eliminación de productos
  * Creación de movimiento de entrada
  * Creación de movimiento de salida
  * Creación de movimiento de ajuste
  * Obtención de movimientos

---

## Cómo ejecutar el proyecto

Este proyecto está pensado para ejecutarse en un entorno de desarrollo (IDE).

### Requisitos

* Java JDK 17 o superior
* Maven
* MySQL (local)
* IDE compatible con Spring Boot (IntelliJ IDEA recomendado)

### Pasos

1. Clonar el repositorio

   ```bash
   git clone https://github.com/SdrNahui/StockManagementAPI-REST.git
   ```

2. Crear una base de datos MySQL local

3. Configurar credenciales en:

   * `application-local.properties`

4. Asegurarse de tener activo el perfil `local`

5. Ejecutar la aplicación desde la clase principal de Spring Boot

6. Probar los endpoints con Postman

---

## Estado del proyecto

* Funcional
* Persistente
* Probado con Postman
* Versión: **v1.0**

---

## Conceptos aplicados

- Arquitectura MVC
- Programación Orientada a Objetos
- Lógica de negocio
- Refactorización incremental
- Base de datos relacional
- Aprendizaje prueba y error

---

## Conceptos aprendidos

- Qué es un DTO
- Qué es un Request y un Response
- Qué es una respuesta HTTP
- Qué es una Primary key y Foreign key
- Relaciones entre entidades
- Manejo de excepciones personalizadas
- Manejo global de excepciones

---

## Notas

Proyecto enfocado en el **aprendizaje progresivo**, priorizando la comprensión de conceptos por sobre la complejidad o la optimización.
