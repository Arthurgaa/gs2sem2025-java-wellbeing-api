# Wellbeing API (Backend)
Java 17 + Spring Boot 3.3.5 + H2.

## Rodar
```bash
mvn spring-boot:run
```
- API: http://localhost:8080
- H2: http://localhost:8080/h2-console (JDBC `jdbc:h2:mem:wellbeingdb`)

## Endpoints principais
- `/api/pacientes` (GET, POST)
- `/api/pacientes/{id}` (GET, PUT, DELETE)
- `/api/registros-diarios` (GET, POST)
- `/api/registros-diarios/{id}` (GET, PUT, DELETE)
