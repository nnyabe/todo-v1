# 📝 Todo Application

A full-stack, responsive Todo app with a Spring Boot backend and a clean, interactive frontend.

## 🚀 Overview

This project is a complete Todo management solution that enables users to:

* Create, read, update, and delete (CRUD) tasks
* Track deadlines with date and time
* Mark tasks as completed or pending
* Toggle between dark and light themes
* Store all task data persistently using AWS DynamoDB

## ⚙️ Tech Stack

### 🔧 Backend
* Spring Boot 3.3.4
* Java 21
* AWS DynamoDB (NoSQL database)
* Maven (build tool)

### 🎨 Frontend
* HTML5, CSS3
* Vanilla JavaScript
* Responsive design with dark/light mode toggle

## ✅ Features

* Full CRUD operations for todos
* Toggle task status (completed or pending)
* Auto-move tasks between pending/completed lists
* Real-time task display with smooth UI updates
* Dark mode & light mode
* Timestamp (date + time) tracking per task
* Clean and minimalist UI with responsive design

## 📁 Project Structure

```
todo-application/
├── backend/
│   ├── src/main/java/dynamo/to_do/
│   │   ├── ToDoApplication.java          # Spring Boot entry point
│   │   ├── config/
│   │   │   └── DynamoDBConfig.java       # AWS DynamoDB client setup
│   │   └── todo/
│   │       ├── model/                    # Data model for Todo item
│   │       ├── repository/               # DynamoDB interactions
│   │       ├── service/                  # Business logic
│   │       └── controller/               # REST API endpoints
│   └── pom.xml                           # Maven configuration
└── frontend/
    ├── index.html                        # Main HTML page
    ├── style.css                         # Styling for UI and themes
    └── script.js                         # JavaScript logic
```

## 🧰 Prerequisites

Make sure the following tools/services are set up before starting:

### 1. Java 21
Install and verify:
```bash
java --version
```

### 2. Maven
Install and verify:
```bash
mvn --version
```

### 3. AWS DynamoDB Table
* Table name: `Todos`
* Partition key: `id` (String)

### 4. AWS Credentials
Provide access to DynamoDB via:

* Environment variables:
  ```bash
  export AWS_ACCESS_KEY_ID=your-key
  export AWS_SECRET_ACCESS_KEY=your-secret
  ```
* AWS CLI:
  ```bash
  aws configure
  ```
* IAM Role (if using EC2, Lambda, etc.)

## 🛠️ Setup Guide

### 🔙 Backend Setup

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd todo-application/backend
   ```

2. Create DynamoDB Table:
    * Use AWS Console or CLI
    * Table name: `Todos`
    * Partition key: `id` (String)

3. Build and run the backend:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   Backend will run at: http://localhost:8080

### 🖥️ Frontend Setup

Open `index.html` directly in a browser, or run a local server:
```bash
cd frontend
python -m http.server 3000
```

Access frontend:
Open http://localhost:3000 in your browser.

## 📡 API Reference

All API routes are under `/api/todos`.

### 🔸 Create Todo
**POST** `/api/todos`
```json
{
  "heading": "Meeting",
  "description": "Team sync",
  "date": "2025-04-04",
  "time": "14:30",
  "completed": false
}
```
Returns: 201 Created

### 🔸 Get All Todos
**GET** `/api/todos`
Returns: 200 OK

### 🔸 Get Todo by ID
**GET** `/api/todos/{id}`
Returns: 200 OK or 404 Not Found

### 🔸 Update Todo
**PUT** `/api/todos/{id}`
```json
{
  "heading": "Updated Meeting",
  "description": "New time",
  "date": "2025-04-05",
  "time": "15:00", 
  "completed": true
}
```
Returns: 200 OK or 404 Not Found

### 🔸 Delete Todo
**DELETE** `/api/todos/{id}`
Returns: 204 No Content or 404 Not Found

## 🧪 API Testing (with cURL)

```bash
# Create
curl -X POST http://localhost:8080/api/todos \
-H "Content-Type: application/json" \
-d '{"heading":"Meeting","description":"Sync","date":"2025-04-04","time":"14:30","completed":false}'

# Get all
curl http://localhost:8080/api/todos

# Get by ID
curl http://localhost:8080/api/todos/{id}

# Update
curl -X PUT http://localhost:8080/api/todos/{id} \
-H "Content-Type: application/json" \
-d '{"heading":"Updated","description":"Updated","date":"2025-04-05","time":"15:00","completed":true}'

# Delete
curl -X DELETE http://localhost:8080/api/todos/{id}
```

## 🚧 Future Enhancements

* Input validation on both frontend and backend
* Authentication and user-specific todos
* Pagination and search/filter support
* Use virtual threads for concurrency
* Unit and integration tests
* Add frontend transitions and animations

## 🤝 Contributing

We welcome contributions!

1. Fork the repository
2. Create a new branch
3. Commit your changes
4. Submit a pull request
