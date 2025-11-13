# GS 2025 --- API de Bem-Estar e Saúde Mental

Plataforma full-stack para monitoramento de bem-estar em ambientes de
trabalho, conectada ao **Futuro do Trabalho** e à **ODS 8 (Trabalho
Decente e Crescimento Econômico)**.\
Permite cadastrar pacientes, registrar humor/ansiedade/sono e integrar
dados com dashboards futuros.

------------------------------------------------------------------------

# 🧠 Tecnologias Utilizadas

## Backend

-   Java **17**
-   Spring Boot **3.2.5**
-   Maven
-   Spring Web
-   Spring Data JPA
-   Bean Validation (jakarta.validation)
-   Banco **H2** em memória
-   Seeds automáticas

## Frontend

-   React + Vite
-   Axios
-   CSS customizado (tema neon)

------------------------------------------------------------------------

# 🚀 Como Rodar o Projeto (Windows)

## Backend

``` bash
cd backend
mvn spring-boot:run
```

-   **API:** http://localhost:8080\
-   **Console H2:** http://localhost:8080/h2-console
    -   JDBC: `jdbc:h2:mem:wellbeingdb`\
    -   User: `sa`\
    -   Password: *(vazio)*

------------------------------------------------------------------------

## Frontend

``` bash
cd frontend
npm install
npm run dev
```

-   **Aplicação:** http://localhost:5173

------------------------------------------------------------------------

# 🗂️ CRUDs Implementados

## 1. Pacientes

    GET    /api/pacientes
    GET    /api/pacientes/{id}
    POST   /api/pacientes
    PUT    /api/pacientes/{id}
    DELETE /api/pacientes/{id}

## 2. Registros Diários

    GET    /api/registros-diarios
    GET    /api/registros-diarios/{id}
    POST   /api/registros-diarios
    PUT    /api/registros-diarios/{id}
    DELETE /api/registros-diarios/{id}

------------------------------------------------------------------------

# 📌 Exemplos de Requisições (Postman / Insomnia)

## Criar Paciente (POST)

``` json
{
  "nome": "Ana Silva",
  "email": "ana@empresa.com",
  "dataNascimento": "1995-05-20"
}
```

## Criar Registro Diário (POST)

``` json
{
  "pacienteId": 1,
  "humor": 4,
  "ansiedade": 2,
  "sonoHoras": 7,
  "dataRegistro": "2025-11-12"
}
```

------------------------------------------------------------------------

# 🗄️ Configuração do Banco

-   Banco: **H2 em memória**
-   Hibernate: `spring.jpa.hibernate.ddl-auto=create`
-   Seeds carregadas automaticamente:
    -   Pacientes
    -   Profissionais
    -   Especialidades
    -   Recursos de apoio

------------------------------------------------------------------------

# ⚙️ Arquitetura (Clean Layers)

    controller → dto → mapper → service → repository → entity

-   **Controller:** recebe requisições e retorna DTOs\
-   **Service:** regras de negócio e validações\
-   **Repository:** Spring Data JPA\
-   **Mapper:** Entity ⇄ DTO\
-   **Exception Handler:** erros centralizados e mensagens claras

------------------------------------------------------------------------

# 🔒 Validações (Bean Validation)

## Pacientes

-   `@NotBlank` nome\
-   `@Email` email\
-   `@Past` dataNascimento

## Registros Diários

-   humor → `@Min(1)` `@Max(5)`\
-   ansiedade → `@Min(1)` `@Max(5)`\
-   dataRegistro → `@NotNull`

------------------------------------------------------------------------

# 👥 Integrantes

-   **Arthur Galvão Alves** --- RM554462\
-   **Felipe Braunstein e Silva** --- RM554483\
-   **Lorenzo Hayashi Mangini** --- RM554901

------------------------------------------------------------------------

# 🌱 Conexão com o Tema GS / ODS

O projeto reforça: - Monitoramento de bem-estar no **Futuro do
Trabalho**\
- Apoio à saúde mental em ambientes corporativos\
- Contribuição direta com a **ODS 8**, promovendo produtividade e
qualidade de vida
