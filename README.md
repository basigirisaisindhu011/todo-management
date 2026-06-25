# 📝 Todo Management Application

A secure Todo Management REST API built using Spring Boot, Spring Security, JWT Authentication, Spring Data JPA, Hibernate, and MySQL.

The application provides user registration, login, role-based authorization, and complete CRUD operations for managing todo tasks.

---

## 🚀 Features

### 🔐 Authentication & Authorization

* User Registration
* User Login
* JWT Token Generation
* Bearer Token Authentication
* Spring Security Integration
* Role-Based Access Control (ADMIN / USER)

### ✅ Todo Management

* Create Todo (ADMIN only)
* Get Todo By ID (ADMIN & USER)
* Get All Todos (ADMIN & USER)
* Update Todo (ADMIN only)
* Delete Todo (ADMIN only)
* Mark Todo as Complete (ADMIN & USER)
* Mark Todo as Incomplete (ADMIN & USER)

### ⚠️ Exception Handling

* Global Exception Handling
* Custom API Exceptions
* Resource Not Found Handling

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok

---

## 📂 Project Structure

```text
src/main/java/com/project/todo

├── controller
│   ├── AuthController
│   └── TodoController
│
├── dto
│   ├── JwtAuthResponse
│   ├── LoginDto
│   ├── RegisterDto
│   └── TodoDto
│
├── entity
│   ├── User
│   ├── Role
│   └── Todo
│
├── exception
│   ├── ErrorDetails
│   ├── GlobalExceptionHandler
│   ├── ResourceNotFoundException
│   └── TodoAPIException
│
├── repository
│   ├── UserRepo
│   ├── RoleRepo
│   └── TodoRepo
│
├── security
│   ├── CustomUserDetailsService
│   ├── JwtAuthenticationFilter
│   ├── JWTAuthenticationEntryPoint
│   └── JWTTokenProvider
│
├── service
│   ├── AuthService
│   ├── TodoService
│   └── impl
│
└── TodoManagementApplication
```

---

## 🔑 Authentication APIs

### Register User

**POST** `/api/auth/register`

### Login User

**POST** `/api/auth/login`

Returns a JWT access token which must be used in the Authorization header:

```http
Authorization: Bearer <jwt-token>
```

---

## 📋 Todo APIs

### Create Todo

**POST** `/api/todos`

### Get Todo By ID

**GET** `/api/todos/{id}`

### Get All Todos

**GET** `/api/todos`

### Update Todo

**PUT** `/api/todos/{id}`

### Delete Todo

**DELETE** `/api/todos/{id}`

### Complete Todo

**PATCH** `/api/todos/{id}/complete`

### Incomplete Todo

**PATCH** `/api/todos/{id}/incomplete`

---

## 🔒 Authorization Rules

| API Operation   | ADMIN | USER |
| --------------- | ----- | ---- |
| Create Todo     | ✅     | ❌    |
| Get Todo By ID  | ✅     | ✅    |
| Get All Todos   | ✅     | ✅    |
| Update Todo     | ✅     | ❌    |
| Delete Todo     | ✅     | ❌    |
| Complete Todo   | ✅     | ✅    |
| Incomplete Todo | ✅     | ✅    |

---

## 📸 API Screenshots

### Authentication

* Register User
* Login User
* JWT Token Generation

### Todo Operations

* Create Todo (Admin)
* Get Todo By ID (Admin)
* Get Todo By ID (User)
* Get All Todos (Admin)
* Get All Todos (User)
* Update Todo (Admin)
* Delete Todo (Admin)
* Complete Todo (Admin)
* Complete Todo (User)
* Incomplete Todo (User)
* Access Todo APIs Using JWT Token

Screenshots are available inside the `screenshots` folder.

---

## 🎯 Learning Outcomes

This project demonstrates:

* Spring Boot REST API Development
* Spring Security Configuration
* JWT Authentication & Authorization
* Role-Based Access Control (RBAC)
* DTO Pattern
* Exception Handling
* JPA & Hibernate
* MySQL Integration
* Layered Architecture
* Secure API Development

---

## 🔮 Future Enhancements

* Refresh Token Support
* Email Verification
* Password Reset Feature
* Swagger/OpenAPI Documentation
* Docker Deployment
* Unit & Integration Testing
* Pagination and Sorting
* User Profile Management

---

## 👨‍💻 Author

**Sindhu**

Java Backend Developer | Spring Boot Developer

---
