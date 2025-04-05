# LoadSync

A Spring Boot + PostgreSQL backend to manage Load and Booking operations efficiently.

## Features
- CRUD operations for Load and Booking entities
- Validation, logging, and error handling
- Status management based on business rules

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL

## API Endpoints

### Load APIs
- `POST /load` – Create a load
- `GET /load` – Get loads (filterable)
- `GET /load/{id}` – Get load by ID
- `PUT /load/{id}` – Update load
- `DELETE /load/{id}` – Delete load

### Booking APIs
- `POST /booking` – Create a booking
- `GET /booking` – Get bookings (filterable)
- `GET /booking/{id}` – Get booking by ID
- `PUT /booking/{id}` – Update booking
- `DELETE /booking/{id}` – Delete booking

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/fuzail-pixel/LoadSync.git
   cd LoadSync
