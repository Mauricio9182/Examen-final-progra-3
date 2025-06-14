# Proyecto Examen Final - Programación 3

Proyecto desarrollado con Quarkus para cumplir los retos del examen final del curso Programación 3, aplicando principios SOLID y buenas prácticas en diseño y desarrollo de APIs REST.

---

## Objetivos y funcionalidades principales

### Serie I 
Implementar dos algoritmos clásicos en Java con tests unitarios:

1. **Validar Sudoku**  
   Determinar si un tablero 9x9 es válido según las reglas:  
   - Cada fila sin números repetidos (1-9)  
   - Cada columna sin números repetidos (1-9)  
   - Cada subcuadro 3x3 sin números repetidos (1-9)  
   El tablero puede estar parcialmente lleno y no es necesario encontrar solución, solo validar.

2. **Secuencia de Fibonacci**  
   Función Java que genera los primeros n elementos de Fibonacci, con parámetros:  
   - Un arreglo de 2 elementos con la "firma" inicial  
   - Un entero n, cantidad de elementos a devolver  
   Incluye ejemplos y manejo de casos base.

---

### Serie II 
Extensión del proyecto Quarkus para mejorar diseño y añadir nueva entidad:

1. **Refactorización del API `/person`**  
   - Aplicar el principio de Responsabilidad Única (SRP)  
   - Usar interfaces para abstraer servicios  
   - Extraer mapeo Person <-> PersonDto a clase dedicada  
   - Justificar cambios con comentarios en código

2. **Creación de la entidad `Address` y su CRUD**  
   - Definir entidad `Address` simple con relación a `Person`  
   - Implementar métodos POST (crear) y GET (listar) para `Address`  
   - Permitir consultar direcciones desde persona: `/person/{id}/addresses`  
   - Aplicar buenas prácticas en diseño (servicios, DTOs, inyección CDI, transacciones)

---

## Tecnologías

- Java 17  
- Quarkus 3.3.0  
- Hibernate ORM con Panache  
- PostgreSQL 17  
- RESTEasy Reactive para REST  
- Jakarta EE (CDI, JPA, Transactions)  
- Maven  
- Lombok

---

## Endpoints principales

| Método | Endpoint                 | Descripción                            |
|--------|--------------------------|--------------------------------------|
| POST   | /person                  | Crear nueva persona                   |
| GET    | /person                  | Listar todas las personas             |
| GET    | /person/{id}/addresses   | Listar direcciones de una persona     |
| POST   | /address                 | Crear nueva dirección                  |
| GET    | /address                 | Listar todas las direcciones           |
| GET    | /address/person/{id}     | Listar direcciones por ID de persona  |

---
