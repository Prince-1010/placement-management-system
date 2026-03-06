# Placement Management System

A backend REST API for managing college placement activities built using *Spring Boot, **Spring Security, and **JWT Authentication*.

## 🚀 Features

- Student Registration & Login
- Company Management
- Apply for Company
- Application Status Tracking
- JWT Based Authentication
- Role Based Authorization (Admin / Student)
- Secure REST APIs
- MySQL Database Integration

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Hibernate / JPA
- MySQL
- Maven
- Postman (API Testing)

## 📂 Project Structure


src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── config
 └── security


## 🔑 Authentication Flow

1. User registers or logs in
2. Server generates *JWT Token*
3. Token is sent in request header


Authorization: Bearer <token>


4. JWT Filter validates the token
5. Access granted to secured APIs

## 📡 API Endpoints

### Authentication

| Method | Endpoint | Description |
|------|------|------|
| POST | /auth/register | Register user |
| POST | /auth/login | Login and get JWT token |

### Company

| Method | Endpoint | Description |
|------|------|------|
| GET | /companies | Get all companies |
| POST | /companies | Add company (Admin) |

### Application

| Method | Endpoint | Description |
|------|------|------|
| POST | /applications/apply | Apply for company |
| GET | /applications | View applications |
| PUT | /applications/status/{id} | Update application status |

## 🗄 Database

MySQL database is used.

Example configuration in application.properties:


spring.datasource.url=jdbc:mysql://localhost:3306/placement_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


## ▶️ Running the Project

1. Clone the repository


git clone https://github.com/yourusername/placement-management-system.git


2. Open project in *IntelliJ / Eclipse*

3. Run the application


mvn spring-boot:run


4. Test APIs using *Postman*

## 📸 API Testing

Use Postman to test secured APIs by adding JWT token in headers.

## 📌 Future Improvements

- Refresh Token
- Pagination
- Email Notification
- Swagger Documentation
- Deployment (Render / Railway / AWS)
