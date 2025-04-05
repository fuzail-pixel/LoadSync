# LoadSync
Spring Boot backend for managing loads, bookings, and freight scheduling in a logistics system.

## Overview
**LoadSync** is a Spring Boot-based logistics management backend. It enables users to post freight loads, book them via transporters, and schedule their transportation. Designed with modular architecture and developer-friendly endpoints, it supports fast prototyping, easy testing, and scalable deployment.

## Features
- **RESTful APIs** for load posting, booking, and schedule uploads
- **CRUD support** for Loads, Bookings, and Schedulers
- **Upload JSON files** for schedule planning
- **Auto-generated UUIDs** and timestamps for data tracking
- **H2 database** integration for quick development/testing
- **Admin login** enabled via Spring Security (username: `chairman`, password: `admin123`)
- **Open for containerization and CI/CD**

## Tech Stack
- **Backend:** Java 17, Spring Boot 3.x, Spring Data JPA
- **Database:** H2 (development), supports others (MySQL/PostgreSQL)
- **Build Tool:** Maven
- **Security:** Spring Security (basic auth)
- **Utilities:** Lombok

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/fuzail-pixel/LoadSync.git
   cd LoadSync
