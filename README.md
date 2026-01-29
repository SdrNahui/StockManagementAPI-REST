# TaskManager API REST

Proyecto personal y autodidacta de **API REST** desarrollado con **Spring Boot**, orientado a la gestión de tareas.

El objetivo principal es practicar el desarrollo backend con Java, entendiendo cómo interactúan una API, la persistencia de datos y las herramientas del ecosistema Spring.
Permite gestionar tareas pendientes con endpoints CRUD.
---

## Objetivo del proyecto

* Comprender qué es y cómo funciona una **API REST**
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
  
#### Task
- id
- name
- description
- completed

---

## Endpoints principales

| Método | Endpoint          | Descripción                  |
|--------|-------------------|------------------------------|
| GET    | /api/tasks        | Obtener todas las tareas     |
| GET    | /api/tasks/{id}   | Obtener tarea por ID         |
| POST   | /api/tasks        | Crear nueva tarea            |
| PUT    | /api/tasks/{id}   | Actualizar una tarea         |
| DELETE | /api/tasks/{id}   | Eliminar una tarea           |

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

  * Creación de tareas
  * Obtención de tareas
  * Actualización
  * Eliminación

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
   git clone https://github.com/SdrNahui/TaskManagerAPI-REST.git
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
- Aprendizaje prueba y error

---

## Conceptos aprendidos

- Qué es una API
- Qué es REST
- Qué es un Endpoint
- Qué es Postman
- Qué es Spring Boot
- Qué es una base de datos relacional

---

## Notas

Proyecto enfocado en el **aprendizaje progresivo**, priorizando la comprensión de conceptos por sobre la complejidad o la optimización.
