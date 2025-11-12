# GS 2025 — Wellbeing API (Back + Front)

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
