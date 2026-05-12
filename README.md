Rewards API
	A Spring Boot RESTful application that calculates customer reward points based on purchase transactions over a three-month period.

Reward Rules
		○ 2 points for every dollar spent above $100
		○ 1 point for every dollar spent between $50 and $100
		○ No points for purchases less than or equal to $50
Example
	A purchase of $120 earns:
		○ 2 × $20 = 40 points
		○ 1 × $50 = 50 points
	Total = 90 points

Tech Stack
		○ Java 21
		○ Spring Boot 3.3.5
		○ Maven
		○ JUnit 5

API Endpoint
	Calculate Customer Rewards
	HTTP Method: POST

Endpoint URL
	http://localhost:8080/api/rewards

Content-Type
application/json

Sample Request Body
	[
  {
    "customerId": "C1",
    "amount": 180,
    "transactionDate": "2026-01-10"
  },
  {
    "customerId": "C1",
    "amount": 75,
    "transactionDate": "2026-01-20"
  },
  {
    "customerId": "C1",
    "amount": 456,
    "transactionDate": "2026-02-15"
  },
  {
    "customerId": "C2",
    "amount": 60,
    "transactionDate": "2026-01-05"
  },
  {
    "customerId": "C2",
    "amount": 130,
    "transactionDate": "2026-03-25"
  },
  {
    "customerId": "C3",
    "amount": 70,
    "transactionDate": "2026-03-25"
  },
  {
    "customerId": "C3",
    "amount": 80,
    "transactionDate": "2026-03-25"
  }
]

Sample Response
	[
  {
    "customerId": "C3",
    "monthlyPoints": {
      "2026-03": 50
    },
    "totalPoints": 50
  },
  {
    "customerId": "C1",
    "monthlyPoints": {
      "2026-01": 235,
      "2026-02": 762
    },
    "totalPoints": 997
  },
  {
    "customerId": "C2",
    "monthlyPoints": {
      "2026-01": 10,
      "2026-03": 110
    },
    "totalPoints": 120
  }
]

Exception Handling
	The application uses centralized exception handling using:
		○ Custom exception classes
		○ Global exception handler using @RestControllerAdvice
	Invalid transactions such as:
		○ Negative transaction amounts
		○ Missing transaction dates
	will return proper error responses with HTTP status codes.

Running the Application
	Run this command on terminal : mvn spring-boot:run
	Application runs on: http://localhost:8080

Running Tests
	mvn test

Features
		○ RESTful POST API
		○ Monthly reward aggregation
		○ Total reward calculation
		○ Centralized exception handling
		○ Unit testing using JUnit 5
		○ Clean layered architecture
		○ JavaDocs for maintainability

Assumptions
		○ Reward points are calculated per transaction.
		○ Rewards are aggregated monthly and per customer.
		○ Invalid transactions are rejected using custom exception handling.

Author
Harsh Singh
