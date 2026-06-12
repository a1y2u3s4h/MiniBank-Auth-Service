# MiniBank Authentication Service

## Overview

MiniBank Authentication Service is a secure backend authentication system built using Spring Boot and Spring Security.

The project provides user registration, login authentication, password encryption using BCrypt, JWT token generation, JWT token validation, and protected REST APIs.

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* MySQL
* JWT (JSON Web Token)
* BCrypt Password Encoder
* Maven

---

## Features

* User Registration
* Login Authentication
* Password Encryption using BCrypt
* JWT Token Generation
* JWT Token Validation
* Protected APIs
* Request Validation
* Global Exception Handling
* MySQL Database Integration

---

## API Endpoints

### Register User

POST /auth/register

### Login User

POST /auth/login

### Test Endpoint

GET /auth/test

### Protected Profile Endpoint

GET /auth/profile

---

## Project Structure

src/main/java

* controller
* service
* repository
* model
* dto
* security
* exception

---

## Security Flow

1. User registers with email and password.
2. Password is encrypted using BCrypt before storing in the database.
3. User logs in with credentials.
4. JWT token is generated after successful authentication.
5. Client sends JWT token in Authorization header.
6. JwtFilter validates token before allowing access to protected APIs.

---

## Future Enhancements

* Role Based Access Control (ADMIN / USER)
* Swagger API Documentation
* Refresh Token Support
* Account Service Integration

---

## Author

Ayush Chitransh

