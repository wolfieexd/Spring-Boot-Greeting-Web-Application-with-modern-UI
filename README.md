# 🎉 Greeting Web Application

A simple Spring Boot REST API web application that provides greeting endpoints with a user-friendly interface.

## Project Overview

This is a Spring Boot application built with:
- **Java Version**: 17
- **Spring Boot Version**: 3.3.0
- **Build Tool**: Maven
- **Web Framework**: Spring Web MVC

## Features

- 🚀 Simple REST API endpoints for greeting messages
- 💾 In-memory storage of greetings
- 🎨 Beautiful HTML welcome page
- 🧪 Comprehensive unit tests
- 🔧 Development tools included (DevTools)

## Project Structure

```
src/
├── main/
│   ├── java/com/example/
│   │   ├── GreetingApplication.java      # Main Spring Boot application class
│   │   ├── controller/
│   │   │   └── GreetingController.java   # REST controller with greeting endpoints
│   │   └── model/
│   │       └── Greeting.java             # Greeting model class
│   └── resources/
│       ├── application.properties         # Application configuration
│       └── static/
│           └── index.html                # Welcome page
└── test/
    └── java/com/example/controller/
        └── GreetingControllerTest.java   # Unit tests
```

## REST API Endpoints

### 1. Simple Hello Endpoint
```
GET /api/hello
```
Returns a simple welcome message.

**Example:**
```bash
curl http://localhost:8080/api/hello
```

**Response:**
```
Welcome to the Greeting Web Application!
```

---

### 2. Get Greeting (Default or Custom Name)
```
GET /api/greeting?name={name}
```
Returns a personalized greeting message.

**Parameters:**
- `name` (optional, default: "World") - The name to greet

**Example:**
```bash
curl http://localhost:8080/api/greeting?name=Alice
```

**Response:**
```json
{
  "id": 1,
  "message": "Hello, Alice!",
  "name": "Alice"
}
```

---

### 3. Get Custom Greeting
```
GET /api/custom-greeting?name={name}&template={template}
```
Returns a greeting with a custom template.

**Parameters:**
- `name` (optional, default: "Friend") - The name to greet
- `template` (optional, default: "Hello, %s!") - The greeting template (use %s for name placeholder)

**Example:**
```bash
curl "http://localhost:8080/api/custom-greeting?name=Bob&template=Hi, %s!"
```

**Response:**
```json
{
  "id": 2,
  "message": "Hi, Bob!",
  "name": "Bob"
}
```

---

### 4. Get All Greetings
```
GET /api/greetings
```
Returns all stored greetings.

**Example:**
```bash
curl http://localhost:8080/api/greetings
```

**Response:**
```json
[
  {
    "id": 1,
    "message": "Hello, Alice!",
    "name": "Alice"
  },
  {
    "id": 2,
    "message": "Hi, Bob!",
    "name": "Bob"
  }
]
```

---

### 5. Create a Greeting (POST)
```
POST /api/greeting
Content-Type: application/json

{
  "message": "Hello",
  "name": "Test"
}
```
Creates a new greeting.

**Example:**
```bash
curl -X POST http://localhost:8080/api/greeting \
  -H "Content-Type: application/json" \
  -d '{"message":"Bonjour","name":"French Friend"}'
```

**Response:**
```json
{
  "id": 3,
  "message": "Bonjour",
  "name": "French Friend"
}
```

---

### 6. Delete All Greetings
```
DELETE /api/greetings
```
Deletes all stored greetings.

**Example:**
```bash
curl -X DELETE http://localhost:8080/api/greetings
```

**Response:**
```
Cleared 3 greeting(s)
```

---

## Getting Started

### Prerequisites
- Java 17 or higher installed
- Maven 3.6+ installed

### Installation & Setup

1. **Clone or navigate to the project directory:**
```powershell
cd "d:\Projects\SpringBoot Greeting webpage"
```

2. **Build the project:**
```powershell
mvn clean install
```

3. **Run the application:**
```powershell
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Access the Application

- **Web Interface:** Open your browser and visit `http://localhost:8080`
- **API Documentation:** The home page displays all available endpoints with descriptions

## Running Tests

To run the unit tests:

```powershell
mvn test
```

To run tests with coverage:

```powershell
mvn clean test
```

## Configuration

The application configuration is defined in `src/main/resources/application.properties`:

```properties
spring.application.name=greeting-app
server.port=8080
server.servlet.context-path=/
logging.level.root=INFO
logging.level.com.example=DEBUG
```

You can modify these properties to change:
- Server port
- Logging levels
- Application name
- Session timeout

## Building for Production

To create an executable JAR file:

```powershell
mvn clean package
```

This will create `target/greeting-app-1.0.0.jar`

To run the JAR:

```powershell
java -jar target/greeting-app-1.0.0.jar
```

## Development

### With IDE Support

If using an IDE like IntelliJ IDEA or Eclipse:
1. Import the project as a Maven project
2. The IDE will automatically download dependencies
3. You can run `GreetingApplication.java` directly from the IDE

### With DevTools

The project includes Spring Boot DevTools for faster development cycles. Changes to Java files are automatically recompiled when you save.

## Project Dependencies

- **spring-boot-starter-web** - Spring Web framework for building REST APIs
- **spring-boot-devtools** - Development tools for faster development
- **spring-boot-starter-test** - Testing framework

## Troubleshooting

### Port 8080 Already in Use
Change the server port in `application.properties`:
```properties
server.port=8081
```

### Build Fails with Java Version Error
Ensure you have Java 17 installed:
```powershell
java -version
```

### Maven Not Found
Add Maven to your PATH or use the Maven Wrapper if available.

## Future Enhancements

- Database integration (JPA/Hibernate)
- Authentication and authorization
- API documentation with Springdoc OpenAPI/Swagger
- Caching implementation
- Error handling and validation
- Containerization with Docker

## License

This is a sample project for educational purposes.

## Author

Created with Spring Boot Initializr

---

**Happy Coding! 🚀**
