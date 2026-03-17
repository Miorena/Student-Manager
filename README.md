# 🎓 Student Management System

A desktop Java application for managing students at ONIFRA, built with Java, JDBC and PostgreSQL.
This project is a complete rewrite of an original C project from first year, now using proper OOP architecture, a real database, and clean package separation.

---

## 🗂️ Project Structure

```
gestion-etudiants/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── univ/
                ├── model/
                │   └── Student.java          # Student entity
                ├── dao/
                │   ├── DatabaseConnection.java  # Singleton JDBC connection
                │   └── StudentDAO.java           # All SQL queries (CRUD)
                ├── service/
                │   └── StudentService.java       # Business logic & validation
                ├── ui/
                │   └── Menu.java                 # Console interface
                └── App.java                      # Entry point
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Database | PostgreSQL 16 |
| DB Connection | JDBC |
| Build Tool | Maven |
| IDE | VS Code + Extension Pack for Java |

---

## ⚙️ Prerequisites

- Java 17+
- PostgreSQL 16+
- Maven 3+

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/gestion-etudiants.git
cd gestion-etudiants
```

### 2. Start PostgreSQL

```bash
sudo systemctl start postgresql
```

### 3. Create the database and table

Connect to PostgreSQL and run:

```sql
CREATE DATABASE gestion_etudiants;
```

Then connect to the database and create the table:

```sql
CREATE TABLE etudiants (
    id               SERIAL PRIMARY KEY,
    nom              VARCHAR(150) NOT NULL,
    prenom           VARCHAR(150) NOT NULL,
    numero_etudiant  INTEGER UNIQUE NOT NULL,
    note_algo        DECIMAL(4,2) CHECK (note_algo >= 0 AND note_algo <= 20),
    note_python      DECIMAL(4,2) CHECK (note_python >= 0 AND note_python <= 20)
);
```

### 4. Configure the database connection

Open `src/main/java/univ/dao/DatabaseConnection.java` and update:

```java
private static final String URL      = "jdbc:postgresql://localhost:5432/gestion_etudiants";
private static final String USER     = "postgres";
private static final String PASSWORD = "your_password_here";
```

### 5. Build and run

```bash
mvn compile
mvn exec:java -Dexec.mainClass="univ.App"
```

---

## ✨ Features

- Add a student with grade validation (0–20)
- Display all students with individual averages
- Search by name (case-insensitive) or student number
- Delete a student by student number
- Calculate class averages
- Find the best student

---

## 📦 Maven Dependency

The PostgreSQL JDBC driver is declared in `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.0</version>
</dependency>
```

---

## 🏗️ Architecture

This project follows a 3-layer architecture:

```
UI (Menu.java)
    ↓  calls
Service (StudentService.java)   ← validation & business logic
    ↓  calls
DAO (StudentDAO.java)           ← SQL queries via JDBC
    ↓  connects via
DatabaseConnection.java         ← Singleton JDBC connection
    ↓
PostgreSQL
```

---

## 📖 Origin

This project started as a C console program in first year (ONIFRA).
The original version used a flat `.txt` file for storage and manual memory management.
This Java version replaces it with a proper relational database, OOP design patterns and clean package separation.

---

## 👤 Author

- **Your Name** — 3rd year student, GLBD (Software Engineering & Databases)
