 Telecom-Subscription-and-Billing-System-Java-Project
Telecom Subscription and Billing System is a full-stack, enterprise-style application designed to simulate a real-world telecommunication service platform. The system manages telecom users, subscription plans, and billing calculations based on service usage.
 Telecom Subscription & Billing System

 Description
Full-stack telecom management system demonstrating:
- Java SE, Spring Boot, Spring Data JPA
- PostgreSQL integration
- REST API + Thymeleaf + JS frontend
- CI/CD pipeline with Bamboo
- Algorithms for billing/user analysis
- Unit tests (JUnit + Mockito)

 Setup
1. Clone repo: `git clone <repo-url>`
2. Create PostgreSQL DB: `telecomdb`
3. Configure `application.properties`
4. Run: `mvn spring-boot:run`
5. Access API at: `http://localhost:8080`

 Endpoints
- `POST /users/create` - create user
- `GET /users/all` - list users
- `POST /admin/plan` - create plan
- `GET /admin/plans` - list plans
- `POST /billing/calculate/{userId}?minutes=X` - calculate billing
