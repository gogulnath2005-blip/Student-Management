# Student Management System

A Java-based Student Management System built with **Core Java, JDBC, MySQL, and Maven**. The project demonstrates how a Java application connects to a relational database to manage student information.

## Overview

The Student Management System is designed to organize student records in a structured way. It uses Java Database Connectivity (JDBC) to communicate with MySQL and Maven to manage the project dependency.

The student model contains the following details:

- Student ID
- Name
- Email
- Course
- Age

This project is intended as a practical demonstration of Java object-oriented programming and database connectivity.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 17 | Application development |
| JDBC | Connecting Java to the database |
| MySQL | Relational database |
| MySQL Connector/J 9.5.0 | MySQL JDBC driver |
| Apache Maven | Dependency and build management |

## Core Concepts Demonstrated

- Java classes and objects
- Encapsulation using private fields
- Constructors and object initialization
- JDBC database connectivity
- Maven dependency management
- Working with relational database records

## Project Structure

```text
Student-Management/
├── src/
│   └── main/
│       └── java/
│           └── ...                 # Java source files
├── pom.xml                         # Maven configuration
└── README.md
```

> The package and class layout above is illustrative. Update it to match the exact files in your repository.

## Prerequisites

Install the following before running the project:

1. Java Development Kit (JDK) 17 or later
2. MySQL Server
3. Apache Maven (or use the Maven wrapper if you add one)
4. An IDE such as IntelliJ IDEA, Eclipse, or VS Code (optional)

Check your Java and Maven installations:

```bash
java -version
mvn -version
```

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/gogulnath2005-blip/Student-Management.git
cd Student-Management
```

### 2. Create the MySQL database

Open MySQL Workbench or the MySQL command line and create a database:

```sql
CREATE DATABASE student_management;
```

If your Java database connection uses a different database name, use that name instead.

### 3. Configure the database connection

Find the database connection class in the Java source code and verify the JDBC URL, username, and password.

A typical MySQL JDBC URL looks like this:

```java
String url = "jdbc:mysql://localhost:3306/student_management";
String username = "root";
String password = "your_mysql_password";
```

Replace the values with your local MySQL configuration. **Do not commit real database passwords or other secrets to GitHub.** For a public project, prefer environment variables or a local configuration file excluded through `.gitignore`.

### 4. Build the project

From the project root, run:

```bash
mvn clean compile
```

### 5. Run the application

Run the class that contains the project's `main()` method from your IDE.

If you configure the Maven Exec Plugin, you can also run the application with:

```bash
mvn exec:java -Dexec.mainClass="your.package.Main"
```

Replace `your.package.Main` with the fully qualified name of the actual main class. The Exec Plugin must be configured in `pom.xml` for this command.

## Database Connectivity

The project uses JDBC to connect Java code with MySQL. The MySQL Connector/J dependency is declared in `pom.xml`, so Maven can download the driver when the project is built.

The configured dependency is:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.5.0</version>
</dependency>
```

## Possible Enhancements

- Add input validation for student details.
- Improve exception handling and user-friendly error messages.
- Move database operations into a dedicated DAO class.
- Store database credentials in environment variables.
- Add automated tests.
- Add a graphical interface or a Spring Boot REST API.

## Learning Outcomes

By building this project, you can practise:

- Structuring a Java Maven application.
- Modelling student data with Java classes.
- Connecting an application to MySQL using JDBC.
- Managing project dependencies with Maven.
- Understanding the fundamentals of database-driven applications.

## Author

**A. Gokulnath**

GitHub: [@gogulnath2005-blip](https://github.com/gogulnath2005-blip)

## Repository

[Student Management System – GitHub](https://github.com/gogulnath2005-blip/Student-Management)
