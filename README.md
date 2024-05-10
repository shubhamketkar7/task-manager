# Task Manager Application

This is a simple task manager application built with Java and Spring Boot.

## Introduction

This application provides a basic task management system where users can create, update, and delete tasks. It also includes a RESTful API for managing tasks programmatically.

## Features

- Create, update, and delete tasks
- View list of tasks
- RESTful API for task management

## Prerequisites

Before running the application, make sure you have the following installed on your system:

- Java 8 or higher
- Maven
- MySQL or any other compatible database

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/task-manager.git
   cd task-manager

2. **Set Up the Database**:

- Create a MySQL database named task_manager.
- Run the following SQL script to create the tasks table:
   ```bash
   CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    priority INT,
    due_date DATE
   );

3. **Configure Database Connection**:

- Open src/main/resources/application.properties file.
- Update the database connection details according to your MySQL configuration:

   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

4. **Build and Run the Application**:
   
- Build the application using Maven:
   ```bash
     mvn clean install

- Run the application:
   ```bash
   java -jar target/taskmanager-1.0.0.jar

5. **Access the Application**:
Open your web browser and go to http://localhost:8080/taskmanager/home to access the application.

## Database Schema

- The application uses a MySQL database with the following schema:  
   ```bash
   CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    priority INT,
    due_date DATE
   );

## Contributing

- Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

### Feel free to customize this README.md file further if needed, and don't forget to replace placeholders like `your-username`, `your_password`, and any others with your actual project details.
