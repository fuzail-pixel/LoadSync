# Load and Booking Management System

A robust backend system built with Spring Boot and PostgreSQL for managing load and booking operations in a logistics platform. This system provides optimized REST APIs for efficient load posting and booking management.

## 🚀 Features

- Complete CRUD operations for Load and Booking entities
- Status management with business rules enforcement
- Input validation and comprehensive error handling
- Optimized for performance and scalability
- Secure API endpoints
- Detailed logging for monitoring and debugging

## 🛠️ Tech Stack

- **Framework**: Spring Boot 3.x
- **Database**: PostgreSQL
- **Security**: Spring Security
- **API Documentation**: Swagger/OpenAPI
- **Testing**: JUnit, Mockito

## 📋 API Specifications

### Load Entity
```json
{
  "id": "UUID",
  "shipperId": "String",
  "facility": {
    "loadingPoint": "String",
    "unloadingPoint": "String",
    "loadingDate": "Timestamp",
    "unloadingDate": "Timestamp"
  },
  "productType": "String",
  "truckType": "String",
  "noOfTrucks": "int",
  "weight": "double",
  "comment": "String",
  "datePosted": "Timestamp",
  "status": "POSTED | BOOKED | CANCELLED"
}
```

### Booking Entity
```json
{
  "id": "UUID",
  "loadId": "UUID",
  "transporterId": "String",
  "proposedRate": "double",
  "comment": "String",
  "status": "PENDING | ACCEPTED | REJECTED",
  "requestedAt": "Timestamp"
}
```

## 📚 API Endpoints

### Load Management
- `POST /load` - Create a new load
- `GET /load` - Fetch loads (supports filtering by shipperId, truckType, etc.)
- `GET /load/{loadId}` - Get specific load details
- `PUT /load/{loadId}` - Update load details
- `DELETE /load/{loadId}` - Delete a load

### Booking Management
- `POST /booking` - Create a new booking
- `GET /booking` - Fetch bookings (supports filtering by shipperId, transporterId)
- `GET /booking/{bookingId}` - Get specific booking details
- `PUT /booking/{bookingId}` - Update booking details
- `DELETE /booking/{bookingId}` - Delete a booking

## 🔒 Business Rules

### Load Rules
- Status defaults to `POSTED` when a load is created
- Status changes to `BOOKED` when a booking is made
- Status changes to `CANCELLED` when a booking is deleted

### Booking Rules
- Bookings cannot be created for loads with `CANCELLED` status
- Booking status changes to `ACCEPTED` when accepted by the shipper

## 🚀 Getting Started

### Prerequisites
- JDK 17+
- Maven 3.6+
- PostgreSQL 12+

### Installation & Setup

1. Clone the repository
```bash
git clone https://github.com/yourusername/load-booking-system.git
cd load-booking-system
```

2. Configure your database in `application.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/loadbooking
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Build the application
```bash
mvn clean install
```

4. Run the application
```bash
java -jar target/load-booking-system.jar
```

## 📝 API Usage Examples

### Create a Load
```bash
curl -X POST http://localhost:8080/load \
  -H "Content-Type: application/json" \
  -d '{
    "shipperId": "SHIP123",
    "facility": {
      "loadingPoint": "Mumbai",
      "unloadingPoint": "Delhi",
      "loadingDate": "2025-04-15T08:00:00",
      "unloadingDate": "2025-04-17T18:00:00"
    },
    "productType": "Electronics",
    "truckType": "Closed",
    "noOfTrucks": 2,
    "weight": 5000,
    "comment": "Handle with care"
  }'
```

### Create a Booking
```bash
curl -X POST http://localhost:8080/booking \
  -H "Content-Type: application/json" \
  -d '{
    "loadId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
    "transporterId": "TRANS456",
    "proposedRate": 25000,
    "comment": "Available for express delivery"
  }'
```

## 🧪 Testing

Run tests with Maven:
```bash
mvn test
```


## 🛡️ Assumptions

1. Authentication and authorization are implemented but not detailed in this README
2. Rate limiting and other API protection measures are in place
3. The system supports concurrency with proper locking mechanisms
4. Transactions are properly managed to ensure data integrity
5. The database schema is optimized for the specific queries required

## 📈 Future Enhancements

- Implement notification service for status changes
- Add analytics endpoints for business intelligence
- Build a caching layer for frequently accessed data
- Create a batch processing system for bulk operations
- Implement a rate calculation service

