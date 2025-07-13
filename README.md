# Vaccine Management System

A comprehensive Spring Boot RESTful web application for managing vaccine information records with advanced CRUD operations and inventory tracking. This application provides a robust API for healthcare organizations to efficiently manage vaccine inventory, monitor availability, and maintain detailed records.

## 🚀 Features

- **Vaccine Registration**: Complete CRUD operations for vaccine records
- **Inventory Management**: Track available doses and stock levels in real-time
- **Cost Management**: Dynamic vaccine cost updates and price tracking
- **Advanced Search**: Search vaccines by name, company, cost ranges, and availability
- **Stock Monitoring**: Real-time vaccine availability and stock checking
- **API Documentation**: Integrated Swagger/OpenAPI documentation
- **Bulk Operations**: Update and delete operations for multiple records

# 🛠️ Tech Stack

This project leverages a robust set of technologies across different layers to ensure scalability, maintainability, and enterprise-grade performance.

| Category                | Technology                    | Description                          |
|-------------------------|-------------------------------|--------------------------------------|
| **Backend** | Java 17+                      | Core programming language            |
|                         | Spring Boot 3.x               | Opinionated application framework    |
|                         | Spring MVC                    | Robust web layer framework           |
|                         | Spring Data JPA               | Simplified data access layer         |
|                         | Hibernate                     | Powerful ORM framework               |
|                         | Jakarta Persistence API (JPA) | Standard for object-relational mapping |
| **API Documentation** | Swagger/OpenAPI 3             | Interactive API documentation        |
|                         | Swagger UI                    | Web-based API testing interface      |
| **Database** | MySQL/PostgreSQL/H2          | Production-ready relational databases |
| **Tools & Libraries** | Lombok                        | Reduces boilerplate code (e.g., getters/setters) |
|                         | Maven                         | Project dependency management and build automation |
|                         | Spring Boot DevTools          | Enhances development productivity and hot-reloading |

## 📋 Prerequisites

| Requirement | Version/Details |
|-------------|-----------------|
| **Java** | 17 or higher |
| **Maven** | 3.6+ |
| **Database** | MySQL 8.0+, PostgreSQL 12+, or H2 (for development) |
| **IDE** | IntelliJ IDEA, Eclipse, VS Code |
| **API Testing Tool** | Postman, Insomnia, or curl |

## 🛠️ Installation

**Backend Installation with IntelliJ IDEA**
1. Open IntelliJ IDEA and select "Open" project.
2. Navigate to the `Vaccine-Management-System` directory.
3. Ensure Java 17 is installed and configured.
4. Click **Run > Run 'VaccineManagementSystemApplication'**.

**Backend Installation with VS Code**
1. Open VS Code and select "Open Folder".
2. Navigate to the `Vaccine-Management-System` directory.
3. Install the "Extension Pack for Java" if not already installed.
4. Open the integrated terminal and run:
   ```bash
   mvn spring-boot:run
   ```

**Alternative Installation via Command Line**
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/vaccine-management-system.git
   cd vaccine-management-system
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

**Access the Application**
Open your browser and navigate to:
```
http://localhost:8484/vaccine-manager
```

**API Documentation**
Access the Swagger UI at:
```
http://localhost:8484/vaccine-manager/swagger-ui.html
```

## 📁 Project Structure

```
vaccine-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/vms/vaccine/
│   │   │       ├── model/
│   │   │       │   └── Vaccine.java
│   │   │       ├── repo/
│   │   │       │   └── IVaccineRepo.java
│   │   │       ├── service/
│   │   │       │   └── VaccineService.java
│   │   │       ├── rest/
│   │   │       │   ├── HelloController.java
│   │   │       │   └── VaccineController.java
│   │   │       └── VaccineManagementSystemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 🎯 Application Flow

### 1. Welcome Endpoint
- **URL**: `GET /` or `GET /home`
- **Description**: Displays welcome message for the application
- **Response**: Plain text greeting message

### 2. Register New Vaccine
- **URL**: `POST /api/register`
- **Description**: Registers a new vaccine in the system
- **Request Body**: JSON with vaccine details
- **Response**: Success message with CREATED status

### 3. Get All Vaccines
- **URL**: `GET /api/get-vaccines`
- **Description**: Retrieves all vaccines from the database
- **Response**: JSON array of vaccine objects

### 4. Check Vaccine Stock
- **URL**: `GET /api/vaccine-stock/{id}`
- **Description**: Checks availability of a specific vaccine
- **Parameters**: Vaccine ID
- **Response**: Stock availability message

### 5. Get Vaccine by ID
- **URL**: `GET /api/get-vaccine/{id}`
- **Description**: Retrieves detailed information about a specific vaccine
- **Parameters**: Vaccine ID
- **Response**: JSON array with vaccine details

### 6. Update Vaccine Cost
- **URL**: `PATCH /api/update-vaccine/{id}/{newCost}`
- **Description**: Updates the cost of a specific vaccine
- **Parameters**: Vaccine ID and new cost
- **Response**: Success message with ACCEPTED status

## 🗄️ Database Schema

### Vaccines Table
| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| Vaccine_Id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | Unique vaccine identifier |
| Vaccine_Name | VARCHAR(255) | NOT NULL | Name of the vaccine |
| Vaccine_Company | VARCHAR(255) | NOT NULL | Manufacturing company |
| Vaccine_Cost_INR | DOUBLE | NOT NULL | Cost in Indian Rupees |
| Available_Doses | INTEGER | DEFAULT 0 | Number of available doses |
| Disease_Effective_Against | VARCHAR(255) | NULLABLE | Target disease/condition |

## 🔗 API Endpoints

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| GET | `/` | Welcome message | None | String |
| GET | `/home` | Welcome message | None | String |
| POST | `/api/register` | Register new vaccine | Vaccine JSON | String |
| GET | `/api/get-vaccines` | Get all vaccines | None | List<Vaccine> |
| GET | `/api/vaccine-stock/{id}` | Check vaccine stock | None | String |
| GET | `/api/get-vaccine/{id}` | Get vaccine by ID | None | List<Vaccine> |
| PATCH | `/api/update-vaccine/{id}/{newCost}` | Update vaccine cost | None | String |

## 📝 Request/Response Examples

### Register New Vaccine
```bash
curl -X POST http://localhost:8484/vaccine-manager/api/register \
  -H "Content-Type: application/json" \
  -d '{
    "vaccineName": "COVID-19 Vaccine",
    "vaccineCompany": "Pfizer",
    "cost": 500.0,
    "availableDoses": 100,
    "effectiveAgainst": "COVID-19"
  }'
```

### Get All Vaccines
```bash
curl -X GET http://localhost:8484/vaccine-manager/api/get-vaccines
```

### Check Vaccine Stock
```bash
curl -X GET http://localhost:8484/vaccine-manager/api/vaccine-stock/1
```

### Update Vaccine Cost
```bash
curl -X PATCH http://localhost:8484/vaccine-manager/api/update-vaccine/1/450.0
```

## ⚙️ Configuration

### Database Configuration (application.properties)
```properties
# Server Configuration
server.port=8484
server.servlet.context-path=/vaccine-manager

# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/vaccine_management
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

```

## 🔍 Advanced Repository Features

The application provides sophisticated querying capabilities through custom repository methods:

### Cost-Based Queries
- Find vaccines by exact cost
- Find vaccines with cost less than or equal to specified amount
- Find vaccines within a cost range

### Search Capabilities
- Case-insensitive vaccine name search (exact and partial)
- Case-insensitive company name search (exact and partial)
- Availability range filtering

### Bulk Operations
- Update vaccine cost by name or ID
- Delete vaccines by name
- Transactional operations for data integrity


### API Testing with Postman
1. Import the Swagger specification
2. Test all endpoints with various scenarios
3. Validate response codes and data integrity

## 🔮 Future Enhancements

- [ ] Testing with JUnit and Mockito
- [ ] User authentication and authorization
- [ ] Role-based access control (Admin, Healthcare Worker, Viewer)
- [ ] Vaccine batch tracking and expiry management
- [ ] Email notifications for low stock
- [ ] Report generation (PDF, Excel)
- [ ] Vaccine appointment scheduling
- [ ] Integration with external health systems
- [ ] Multi-language support
- [ ] Advanced analytics dashboard
- [ ] Docker deployment with Kubernetes support

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 👨‍💻 Author

**Shivam Vyas**
- GitHub: [@shivam-0718](https://github.com/shivam-0718)
- LinkedIn: [Shivam Vyas](https://www.linkedin.com/in/shivam-vyas-1807/)
- Email: shivam.vyas.1807@gmail.com

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Swagger team for API documentation tools
- Lombok project for reducing boilerplate code
- All contributors and testers in the healthcare technology community

---

## 📞 Support

If you encounter any issues or have questions, please:
1. Check the [Issues](https://github.com/yourusername/vaccine-management-system/issues) section
2. Create a new issue if your problem isn't already reported
3. Provide detailed information about your environment and the issue
4. Access the Swagger UI for API documentation and testing

**Happy Coding! 🎉**