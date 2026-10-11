# Pack and Drop — Backend Logistics Application

A RESTful logistics management system for a pickup-and-delivery service, built with Java, Spring Boot, Spring Data JPA, and MySQL.

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white)
![Postman](https://img.shields.io/badge/API%20Tested%20With-Postman-FF6C37?logo=postman&logoColor=white)

## Overview

Pack and Drop is a backend REST API that supports the core operations of a pickup-and-delivery business. It manages four parts of the workflow: **customers** who place requests, the **orders** they create, the **drivers** who fulfil them, and the **deliveries** that record pickup, drop-off, and status.

Each module offers full CRUD (Create, Read, Update, Delete) operations, with data stored in a MySQL database through Spring Data JPA. All endpoints were tested using Postman.

## Features

- Full CRUD APIs for **Customers**, **Orders**, **Drivers**, and **Deliveries** (20 endpoints in total)
- RESTful design with JSON request and response bodies
- Layered architecture: controller, service (interface and implementation), repository, and model
- Persistent storage in MySQL via Spring Data JPA, with tables created automatically by Hibernate
- CORS enabled for `http://localhost:3000` on the Customer and Order endpoints, ready for a React front end
- API endpoints tested with Postman

## Tech Stack

| Category | Technology |
|----------|------------|
| Language | Java 21 |
| Framework | Spring Boot 4.1.1 (Spring Web MVC) |
| Data Access | Spring Data JPA (Hibernate) |
| Database | MySQL (`mysql-connector-j`) |
| Build Tool | Maven (Maven Wrapper included) |
| Utilities | Lombok, Spring Boot DevTools |
| API Testing | Postman |

## API Endpoints

The server runs on port `1919` by default. Replace `{id}` values with the record's ID.

### Customers

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/getCustList` | Get all customers |
| GET | `/getCustomer/{cid}` | Get a customer by ID |
| POST | `/createCustomer` | Create a new customer |
| PUT | `/updateCustomer/{cid}` | Update an existing customer |
| DELETE | `/deleteCustomer/{cid}` | Delete a customer |

### Orders

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/getOrderDetails` | Get all orders |
| GET | `/getOrderDetails/{order_id}` | Get an order by ID |
| POST | `/createOrders` | Create a new order |
| PUT | `/updateOrder/{order_id}` | Update an existing order |
| DELETE | `/deleteOrder/{order_id}` | Delete an order |

### Drivers

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/driversList` | Get all drivers |
| GET | `/driver/{id}` | Get a driver by ID |
| POST | `/newDriverEntry` | Register a new driver |
| PUT | `/updateDriver/{id}` | Update a driver's details |
| DELETE | `/driverleft/{id}` | Remove a driver |

### Deliveries

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/getDeliveryDetails` | Get all deliveries |
| GET | `/getDeliveryInfo/{did}` | Get a delivery by ID |
| POST | `/createDeliveryInfo` | Create a new delivery record |
| PUT | `/updateDeliveryInfo/{did}` | Update a delivery record |
| DELETE | `/deleteDeliveryInfo/{did}` | Delete a delivery record |

## Data Model

| Entity | Table | Fields |
|--------|-------|--------|
| Customer | `Customer_Details` | `cid`, `cName`, `email`, `PhoneNumber`, `Address` |
| Order | `Order_details` | `order_id`, `orderNumber`, `productName`, `quantity`, `weight`, `pickupAddress`, `deliveryAddress`, `orderDate`, `status` |
| Driver | `Driver_details` | `id`, `dname`, `phone`, `licenseNumber`, `vehicleNumber`, `availabilityStatus` |
| Delivery | `delivery_Details` | `did`, `deliveryId`, `orderDetails`, `driver`, `pickupTime`, `deliveryTime`, `status` |

## Project Structure

```
Pack-and-Drop---Backend-Logistics-Application/
├── .mvn/wrapper/                          # Maven Wrapper configuration
├── src/
│   ├── main/
│   │   ├── java/com/restAPI/rsm_pack_and_drop/
│   │   │   ├── controller/                # REST controllers (Customer, Order, Driver, Delivery)
│   │   │   ├── service/                   # Service interfaces and implementations
│   │   │   ├── repo/                      # Spring Data JPA repositories
│   │   │   ├── model/                     # JPA entities
│   │   │   └── RsmPackAndDropApplication.java
│   │   └── resources/
│   │       └── application.properties     # Server and database configuration
│   └── test/                              # Test sources
├── .gitattributes
├── .gitignore
├── mvnw                                   # Maven Wrapper (Linux/macOS)
├── mvnw.cmd                               # Maven Wrapper (Windows)
└── pom.xml                                # Dependencies and build configuration
```

## Getting Started

### Prerequisites

- **Java 21** (JDK)
- **MySQL** installed and running
- **Maven** (optional, since the included Maven Wrapper works without a separate install)

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/Sai-manoj-ranga/Pack-and-Drop---Backend-Logistics-Application.git
   cd Pack-and-Drop---Backend-Logistics-Application
   ```

2. **Create the MySQL database**

   ```sql
   CREATE DATABASE logistics;
   ```

3. **Configure the application** in `src/main/resources/application.properties`:

   ```properties
   server.port=1919

   spring.datasource.url=jdbc:mysql://localhost:3306/logistics
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

   Use your own MySQL username and password. Hibernate creates the tables automatically on first run.

4. **Build the project**

   ```bash
   ./mvnw clean install
   ```

   On Windows, use `mvnw.cmd clean install`.

5. **Run the application**

   ```bash
   ./mvnw spring-boot:run
   ```

   The API is now available at `http://localhost:1919`.

## Usage

Send requests to the endpoints above using [Postman](https://www.postman.com/) or any REST client. A typical flow looks like this:

1. Create a **customer** with `POST /createCustomer`
2. Create an **order** with `POST /createOrders`
3. Register a **driver** with `POST /newDriverEntry`
4. Record the **delivery** with `POST /createDeliveryInfo`, including its order details, driver, pickup and delivery times, and status

**Example: register a driver**

```http
POST http://localhost:1919/newDriverEntry
Content-Type: application/json

{
  "dname": "Sai Manoj",
  "phone": "9876543210",
  "licenseNumber": "TS09 2023 0001234",
  "vehicleNumber": "TS09AB1234",
  "availabilityStatus": "Available"
}
```

The response returns the saved driver, including its generated `id`, which you can then use with `/driver/{id}`, `/updateDriver/{id}`, or `/driverleft/{id}`.

## Screenshots
<img width="1891" height="865" alt="image" src="https://github.com/user-attachments/assets/c3ead81b-c200-4e10-b63c-6b3ebe443962" />
<img width="1918" height="861" alt="image" src="https://github.com/user-attachments/assets/11df7aaa-fa0b-41d0-b068-8ed46877dddf" />
<img width="1885" height="510" alt="image" src="https://github.com/user-attachments/assets/7b20bfde-b16f-48d3-86ca-f7bbf1f0ba3f" />
<img width="1881" height="838" alt="image" src="https://github.com/user-attachments/assets/ebd1d57b-5975-4615-902a-4971e6960dbf" />

## Future Improvements

- Add authentication and authorization (Spring Security with JWT)
- Add request validation and centralized exception handling
- Link orders, drivers, and deliveries with JPA relationships so each delivery references a real order and driver
- Add Swagger / OpenAPI documentation for interactive API docs
- Add unit and integration tests for services and controllers
- Move database credentials to environment variables
- Containerize with Docker for easier setup and deployment

## Author

**Sai Manoj Ranga**

- GitHub: [@Sai-manoj-ranga](https://github.com/Sai-manoj-ranga)
- LinkedIn: [ranga-sai-manoj](https://www.linkedin.com/in/ranga-sai-manoj/)
- Email: saimanojranga1919@gmail.com

