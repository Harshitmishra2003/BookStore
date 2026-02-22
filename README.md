📚 Bookstore Management System – REST API
📌 Project Overview

The Bookstore Management System is a backend RESTful API developed using Spring Boot that enables efficient management of books, users, and orders in an online bookstore.
The system supports role-based authentication, secure JWT-based authorization, and follows REST standards for scalability and maintainability.

This API is designed to serve as the backend for web or mobile applications.

🛠️ Technology Stack

Java 17

Spring Boot

Spring Security (JWT Authentication)

Spring Data JPA (Hibernate)

MySQL / H2 Database

Maven

Swagger / OpenAPI

Lombok

👥 User Roles
Role	Description
ADMIN	Manages books, inventory, and orders
USER	Browses books and places orders
🔐 Authentication & Authorization

JWT-based authentication

Role-based access control

Secure endpoints using Spring Security

Access token + refresh token mechanism

📂 Core Modules & Functionality
1️⃣ User Management

Features:

User registration

User login

Role assignment (USER / ADMIN)

Password encryption using BCrypt

Endpoints:

POST /api/auth/register

POST /api/auth/login

2️⃣ Book Management

Features:

Add new books (Admin only)

Update book details

Delete books

View all books

View book by ID

Stock management

Book Attributes:

Title

Author

Genre

ISBN

Price

Description

Stock

Image URL

Endpoints:

POST /api/books

GET /api/books

GET /api/books/{id}

PUT /api/books/{id}

DELETE /api/books/{id}

3️⃣ Order Management

Features:

Place book orders

View user orders

Admin can view all orders

Order status tracking

Endpoints:

POST /api/orders

GET /api/orders/user

GET /api/orders

4️⃣ Security & Validation

Input validation using DTOs

Custom exception handling

Proper HTTP status codes:

200 OK

201 CREATED

400 BAD REQUEST

401 UNAUTHORIZED

403 FORBIDDEN

404 NOT FOUND

⚙️ Application Workflow

User registers or logs in

JWT token is generated

Token is sent in request headers

Secured endpoints validate the token

Business logic executes

JSON response returned to client

📑 API Documentation (Swagger)

Swagger UI provides interactive API documentation.

URL:

http://localhost:8080/swagger-ui.html

🗄️ Database Design (High-Level)

Tables:

users

roles

books

orders

order_items

Relationships:

One user → many orders

One order → many books

🚀 How to Run the Project
1️⃣ Clone Repository
git clone <repository-url>

2️⃣ Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=root
spring.datasource.password=yourpassword

3️⃣ Run Application
mvn spring-boot:run

🧪 Testing

APIs tested using Postman

Authentication tested with JWT headers

Validation and error handling verified

📦 Future Enhancements

Pagination & sorting

Book search & filters

Payment gateway integration

Order cancellation

Admin dashboard

👨‍💻 Author

Harshit Mishra
Backend Developer – Java & Spring Boot

📄 License

This project is for educational and demonstration purposes.
