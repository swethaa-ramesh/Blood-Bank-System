# Blood Bank Management System (BBMS)

A comprehensive web application for managing blood bank operations, including donor management, inventory tracking, and blood request processing.

## 🏥 Project Overview

The Blood Bank Management System is a full-stack application designed to streamline blood bank operations. It provides a secure, user-friendly interface for managing donors, tracking blood inventory, and processing blood requests efficiently.

## ✨ Features

### 🔐 Authentication & Security
- JWT-based authentication system
- Role-based access control
- Secure password handling
- CORS configuration for cross-origin requests

### 👥 Donor Management
- Register and manage blood donors
- Track donor information and donation history
- Blood group categorization
- Donor eligibility verification

### 🩸 Inventory Management
- Real-time blood inventory tracking
- Blood group-wise stock management
- Expiry date monitoring
- Low stock alerts

### 📋 Request Management
- Blood request processing
- Request status tracking
- Priority-based request handling
- Request approval workflow

### 🎨 User Interface
- Modern, responsive Material-UI design
- Intuitive dashboard layout
- Mobile-friendly interface
- Real-time data updates

## 🛠️ Tech Stack

### Backend
- **Framework**: Spring Boot 3.2.3
- **Language**: Java 17
- **Database**: MySQL 8.0
- **ORM**: Spring Data JPA with Hibernate
- **Security**: Spring Security with JWT
- **Build Tool**: Maven
- **Additional Libraries**:
  - Lombok for boilerplate reduction
  - JJWT for JWT token handling
  - Spring Validation for data validation

### Frontend
- **Framework**: React 18.2.0
- **UI Library**: Material-UI (MUI) 5.17.1
- **Routing**: React Router DOM 6.22.1
- **HTTP Client**: Axios 1.6.7
- **Build Tool**: Create React App
- **Styling**: Emotion (CSS-in-JS)

## 📋 Prerequisites

Before running this application, ensure you have the following installed:

- **Java 17** or higher
- **Node.js 16** or higher
- **MySQL 8.0** or higher
- **Maven 3.6** or higher
- **Git**

## 🚀 Installation & Setup

### 1. Clone the Repository

### 2. Database Setup
1. Start your MySQL server
2. Create a database named `bbms` (or it will be created automatically)
3. Update database credentials in `backend/bbms/src/main/resources/application.properties` if needed

### 3. Backend Setup
```bash
cd backend/bbms
mvn clean install
mvn spring-boot:run
```

The backend will start on `http://localhost:8081`

### 4. Frontend Setup
```bash
cd frontend
npm install
npm start
```

The frontend will start on `http://localhost:3000`

## ⚙️ Configuration

### Backend Configuration
Key configuration settings in `application.properties`:

```properties
# Server port
server.port=8081

# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/bbms?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=Singapore1!

# JWT configuration
jwt.secret=404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970
jwt.expiration=86400000

# CORS configuration
spring.web.cors.allowed-origins=http://localhost:3000,http://localhost:3001
```

### Environment Variables
For production deployment, consider using environment variables for sensitive data:
- Database credentials
- JWT secret
- Server port

## 📁 Project Structure

```
bbms/
├── backend/
│   └── bbms/
│       ├── src/main/java/com/example/bbms/
│       │   ├── controller/     # REST API controllers
│       │   ├── dto/           # Data Transfer Objects
│       │   ├── entity/        # JPA entities
│       │   ├── repository/    # Data access layer
│       │   ├── security/      # JWT and security configuration
│       │   └── service/       # Business logic layer
│       └── src/main/resources/
│           └── application.properties
└── frontend/
    ├── src/
    │   ├── components/        # React components
    │   │   ├── auth/         # Authentication components
    │   │   └── layout/       # Layout components
    │   ├── context/          # React context providers
    │   ├── pages/            # Page components
    │   └── services/         # API service layer
    └── package.json
```

## 🔧 API Endpoints

### Authentication
- `POST /api/auth/login` - User login
- `POST /api/auth/signup` - User registration

### Donor Management
- `GET /api/donors` - Get all donors
- `POST /api/donors` - Create new donor
- `PUT /api/donors/{id}` - Update donor
- `DELETE /api/donors/{id}` - Delete donor

### Inventory Management
- `GET /api/inventory` - Get inventory
- `POST /api/inventory` - Add blood to inventory
- `PUT /api/inventory/{id}` - Update inventory
- `DELETE /api/inventory/{id}` - Remove from inventory

### Request Management
- `GET /api/requests` - Get all requests
- `POST /api/requests` - Create new request
- `PUT /api/requests/{id}` - Update request status

## 🧪 Testing

### Backend Testing
```bash
cd backend/bbms
mvn test
```

### Frontend Testing
```bash
cd frontend
npm test
```

## 🚀 Deployment

### Backend Deployment
1. Build the JAR file:
   ```bash
   cd backend/bbms
   mvn clean package
   ```

2. Run the JAR file:
   ```bash
   java -jar target/bbms-0.0.1-SNAPSHOT.jar
   ```

### Frontend Deployment
1. Build the production version:
   ```bash
   cd frontend
   npm run build
   ```

2. Deploy the `build` folder to your web server

