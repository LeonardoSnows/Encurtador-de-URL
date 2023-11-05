# Encurtador de URL

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white&color=black)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

This project is an API built using **Java, Java Spring, Flyway Migrations, MySql as the database, Spring Security and JWT(Json Web Token) for authentication control.**

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Database](#database)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)

## Installation
1. Clone the repository:

```bash
git clone https://github.com/LeonardoSnows/Encurtador-de-URL.git
```

2. Install dependencies with Maven

3. Install [MySql](https://www.mysql.com/)

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## Database
The project utilizes [MySql](https://www.mysql.com/) as the database. The necessary database migrations are managed using Flyway.

## API Endpoints
The API provides the following endpoints:

```markdown
POST /login - Login into the App

POST /encurtar - this endpoint modify your long URL to short URL
```

## Authentication
The API uses Spring Security for authentication control.

```
{
  "login": "user1",
  "senha": "123456"
}
```
- To create a new user, just modify the migration V2 before the run application.
- The password was crypt by using BCrypt
