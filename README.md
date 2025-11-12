# GS 2025 — Wellbeing API

Plataforma full-stack (Java + Spring Boot no backend e React + Vite no frontend) para cadastro de Pacientes e Registros Diários (humor, ansiedade, sono) com validações, tratamento de exceções, semente inicial de dados (seeds) e H2 em memória.

Conecta-se ao tema “Futuro do Trabalho” e à ODS 8 ao promover ferramentas de monitoramento de bem-estar em ambientes de trabalho, apoiando decisões de saúde ocupacional e melhorando qualidade de vida e produtividade.

## Como rodar (Windows)
### Backend
```bash
cd backend
mvn spring-boot:run
```
- API: `http://localhost:8080`
- H2 Console: `http://localhost:8080/h2-console` (JDBC: `jdbc:h2:mem:wellbeingdb`)

### Frontend
```bash
cd frontend
npm install
npm run dev
```
- App: `http://localhost:5173`

## CRUDs incluídos
- Pacientes `/api/pacientes`
- Registros Diários `/api/registros-diarios`

## Integrantes
- Arthur Galvão Alves - RM554462
- Felipe Braunstein e Silva - RM554483
- Lorenzo Hayashi Mangini - RM554901
