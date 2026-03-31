# Madean-Hive-backend--
Minor Project 

# 🛒 Multi-Vendor eCommerce Platform

A full-stack **Multi-Vendor eCommerce Application** designed and developed to simulate real-world online marketplace systems. This project focuses on **scalable backend architecture, secure transactions, and role-based system design**.

---

## 📌 Overview

This application enables **multiple sellers to list and manage products**, while customers can browse, purchase, and interact with the platform. It supports **Admin, Seller, and Customer roles**, each with dedicated functionalities.

The system is built with a strong focus on **clean architecture, modular design, and real-world backend practices**.

---

## 🚀 Core Features

### 👤 Customer

* Product browsing with category and price filtering
* Cart management (add, update, remove items)
* Secure checkout with payment integration
* Order history and cancellation
* Wishlist functionality
* Product reviews and ratings

---

### 🛍️ Seller

* Seller dashboard with sales insights
* Product CRUD operations
* Order management and tracking
* Inventory and stock handling

---

### ⚙️ Admin

* Centralized admin dashboard
* Seller approval and management
* Coupon and offer management
* Platform monitoring and control

---

## 🧱 Tech Stack

### Backend

* Java, Spring Boot
* Spring Security
* JWT Authentication
* Hibernate (JPA)
* MySQL

### Frontend

* React, TypeScript
* Redux Toolkit
* Tailwind CSS, Material UI
* Axios, React Router

### Payments

* Razorpay, Stripe

---

## 🔐 Security Implementation

* JWT-based authentication
* Role-based authorization (Admin / Seller / Customer)
* Secure REST API design
* Input validation and exception handling

---

## 📊 System Design

* Layered Architecture:

  * Controller → Service → Repository
* RESTful API structure
* Modular and maintainable codebase
* Designed with **microservices scalability in mind**

---

## 🛠️ Setup Instructions

### Clone Repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

### Backend

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm start
```

---

## ⚙️ Configuration

* Configure MySQL in `application.properties`
* Add JWT secret key
* Set payment gateway credentials

Frontend `.env`:

```
REACT_APP_API_URL=http://localhost:8080
```

---

## 💡 Key Highlights

* Designed a **role-based multi-vendor system** from scratch
* Implemented **secure authentication using JWT**
* Integrated **payment gateways for real-world transactions**
* Built scalable backend using **Spring Boot best practices**
* Developed responsive frontend using **React + Redux**

---

## 📌 Future Improvements

* Docker & containerization
* CI/CD pipeline integration
* Advanced analytics dashboard
* Caching using Redis

---

## 👨‍💻 Author

**Dheeraj Sisodiya**

* GitHub: https://github.com/dheerajsisodiya05
* LinkedIn: https://www.linkedin.com/in/dheeraj-s-abb303263/

---
