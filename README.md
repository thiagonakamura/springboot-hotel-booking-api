# Spring Boot Hotel Booking API

A RESTful API built with **Spring Boot** to manage a hotel booking system. This project provides functionalities for handling **users, hotels, rooms, and bookings**, following best practices in **MVC architecture, exception handling, and RESTful API design**.

## 🚀 Features

- ✅ **User Management** - CRUD operations for users.
- ✅ **Hotel Management** - CRUD operations for hotels.
- ✅ **Room Management** - CRUD operations for rooms.
- ✅ **Booking System** - Book and manage hotel reservations.
- ✅ **Exception Handling** - Standardized error responses.
- ✅ **DTO Implementation** - Efficient data transfer.

## 🛠️ Technologies Used

- **Java 17+** (Check `pom.xml` for version)
- **Spring Boot** - Backend framework
- **Spring Web** - API development
- **Spring Data JPA** - Database management
- **Maven** - Dependency management

## 📂 Project Structure

```
src/main/java/com/example/springboot_hotel_booking_api/
│-- config/       # Configuration files
│-- controllers/  # Handles HTTP requests
│-- dtos/         # Data Transfer Objects
│-- exceptions/   # Custom exception handling
│-- services/     # Business logic layer
│-- SpringbootHotelBookingApiApplication.java  # Main entry point
```

## 🏗️ Database Model

Below is the database model used in this project:
![Diagrama Hotel Booking drawio](https://github.com/user-attachments/assets/cca86913-4cad-4975-ac2a-cbb96685c62e)

## 🏗️ Installation & Running

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/yourusername/springboot-hotel-booking-api.git
cd springboot-hotel-booking-api
```

### 2️⃣ Build & Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

### 3️⃣ API Endpoints (Default: `http://localhost:8080`)

| Method | Endpoint        | Description          |
| ------ | -------------- | -------------------- |
| GET    | `/users`       | List all users      |
| POST   | `/users`       | Create a user       |
| GET    | `/hotels`      | List all hotels     |
| POST   | `/hotels`      | Create a hotel      |
| GET    | `/rooms`       | List all rooms      |
| POST   | `/bookings`    | Create a booking    |

## 📌 Example Usage (Postman)

### Create a User (`POST /users`)

#### Request Body
```json
{
  "name": "John Doe",
  "email": "johndoe@email.com",
  "password": "securepassword"
}
```

#### Response
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "johndoe@email.com"
}
```

### Create a Hotel (`POST /hotels`)

#### Request Body
```json
{
  "name": "Grand Hotel",
  "location": "New York",
  "rating": 4.5
}
```

#### Response
```json
{
  "id": 1,
  "name": "Grand Hotel",
  "location": "New York",
  "rating": 4.5
}
```

### Create a Booking (`POST /bookings`)

#### Request Body
```json
{
  "userId": 1,
  "roomId": 2,
  "checkIn": "2025-04-01T14:00:00Z",
  "checkOut": "2025-04-05T12:00:00Z",
  "status": "PENDING"
}
```

#### Response
```json
{
  "id": 1,
  "user": {
    "id": 1,
    "name": "John Doe"
  },
  "room": {
    "id": 2,
    "type": "Deluxe",
    "price": 150.0
  },
  "checkIn": "2025-04-01T14:00:00Z",
  "checkOut": "2025-04-05T12:00:00Z",
  "status": "PENDING"
}
```

## 🤝 Contributing

Feel free to contribute by opening a Pull Request or reporting issues.

## 👨‍💻 Author

Thiago - Entry Level Java Developer 📌 [LinkedIn](https://www.linkedin.com/in/thiago-kenzo-rocha-nakamura-1b24591a5/)

## 📜 License

This project is licensed under the MIT License.

