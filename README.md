# Monitor Sensors

Pet проект для управления сенсорами: хранение характеристик, диапазонов измерений и пользователей.  
Технологии: **Spring Boot 3.5**, **PostgreSQL 17**, **Spring Data JPA (Hibernate)**, **Spring Security**, **Bean Validation**, **Flyway**, **Swagger/OpenAPI**, **Docker**.

---

## 🚀 Основной стек
- **Java 17** + **Spring Boot 3.5**
- **Spring Data JPA** (Hibernate)
- **Spring Security** (Basic Auth, BCrypt)
- **Bean Validation** (`@Valid`, `@NotNull`, `@Positive`, `@AssertTrue`)
- **Flyway** для миграций базы данных
- **PostgreSQL 17**
- **Swagger / OpenAPI** (`springdoc-openapi-starter-webmvc-ui`)
- **Docker**

---

## 📂 Структура проекта
src/main/java/ru/nikitanevmyvaka/monitorsensors
│
├─ configuration/ # Конфигурация Spring Security, Swagger
├─ controller/ # REST контроллеры
├─ model/ # Сущности JPA (Sensor, SensorRange, User)
├─ repository/ # Репозитории Spring Data JPA
├─ service/ # Бизнес-логика

---

## 🗄️ База данных
- Используется **PostgreSQL**.  
- Структура и данные управляются миграциями **Flyway** (папка `src/main/resources/db/migration`).
- Примерные таблицы:
  - `users` — пользователи системы (с уникальным именем)
  - `sensors` — сенсоры, в т.ч. встраиваемый диапазон значений (`SensorRange`).

Основные ограничения:
- `CHECK` для `sensors`: `range_from > 0`, `range_to > 0`, `range_from < range_to`
- `users.name` — `UNIQUE NOT NULL`

---

# 1) собрать образ приложения
docker compose build

# 2) поднять БД и приложение
docker compose up -d

# 3) посмотреть логи приложения
docker compose logs -f app

# 4) открыть приложение
# API:       http://localhost:8080
# Swagger:   http://localhost:8080/swagger-ui/index.html

---

# Безопасность и доступ

Basic Auth — базовая авторизация.

На старте создаётся администратор (логин admin, пароль хранится в виде BCrypt-хеша).

Пример разрешённых эндпоинтов (см. SpringSecurityConfiguration):

GET /api/v1/sensors/welcome — публично

POST /api/v1/users/new-user — публично

GET/POST /api/v1/sensors/** — только для авторизованных

---


# Основные фичи

-CRUD для сенсоров c проверкой диапазонов (range_from < range_to).

-Регистрация пользователей и шифрование пароля.

-Поиск по части строки (через ILIKE или JPQL like).

-Flyway-миграции: создание таблиц, добавление CHECK, сид администратора.

Автор: Невмывака Никита (Burn0_0))
