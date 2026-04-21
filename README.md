# Task Manager Backend Application

## 📌 Overview
This is a backend Task Manager application built to understand how real-world projects are designed and structured. The project follows a layered architecture to ensure clean separation of concerns and maintainability.

## 🏗️ Architecture
The application is structured using the following layers:
- Entity
- Repository
- Service
- Controller
- DTO (Data Transfer Objects)
- Exception Handling (including Global Exception Handler)

## ⚙️ Tech Stack
- Java
- Spring Boot
- PostgreSQL

## ✨ Features
- Create a task
- Update a task
- Delete a task
- Toggle task status
- Structured exception handling with proper client responses
- Logging system:
    - Logs printed on console
    - Logs stored in files
    - Log rotation (7 days retention)
    - File size cap (1GB)

## 📂 Logging
Implemented logging using SLF4J with Logback:
- Supports multiple log levels (INFO, DEBUG, ERROR)
- Logs are stored in files with rotation policy
- Helps in debugging and monitoring backend behavior

## 🚧 Challenges Faced
While building this project, I faced challenges such as:
- Choosing appropriate REST methods (GET, POST, PUT, DELETE)
- Designing the entity structure correctly
- Structuring layered architecture properly
- Implementing meaningful logging instead of just basic logs
- Creating proper exception responses instead of returning generic errors

## 📚 Learnings
- How real backend systems are structured
- Importance of layered architecture
- Proper use of logging in backend systems
- Handling exceptions in a structured and client-friendly way
- Writing clean and maintainable code