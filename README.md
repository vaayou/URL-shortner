# URL Shortener 🔗

A simple and scalable **URL Shortener** built with **Spring Boot**, **MySQL**, and **Thymeleaf**.  
It provides REST APIs for programmatic access and a web frontend for users.

---

## 🚀 Features
- Shorten long URLs into unique short codes
- Redirect to original URLs via short links
- REST API + Web UI (Thymeleaf)
- MySQL database for persistence
- Containerized with Docker
- Ready for deployment on AWS EC2

---

## 🛠️ Tech Stack
- **Backend:** Spring Boot (Java 17+)
- **Database:** MySQL
- **Frontend:** Thymeleaf, Bootstrap
- **Containerization:** Docker, Docker Compose
- **Deployment:** AWS EC2

---

## ⚙️ Setup & Run

Create a MySQL database:

CREATE DATABASE url_shortener;


Update src/main/resources/application.properties with your DB credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener
spring.datasource.username=root
spring.datasource.password=your_password


Start the app:

./mvnw spring-boot:run

Open: http://localhost:8080


### 🔹 Prerequisites
- Install [Java 17+](https://adoptium.net/)  
- Install [Maven](https://maven.apache.org/)  
- Install [Docker](https://docs.docker.com/get-docker/) (optional but recommended)  
- Install [Postman](https://www.postman.com/downloads/) (for API testing)

---

### 🔹 Clone the Repository
```bash
git clone https://github.com/vaayou/URL-shortner.git
cd URL-shortner
