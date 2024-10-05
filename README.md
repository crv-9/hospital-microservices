# Hospital Microservices - Backend Exercise Series

## Overview
This series of web applications is a decentralized system for the simplified management of patients within a hospital. Built using Java Spring Boot with mySQL/MongoDB databases and Spring Security for authentication and authorization. The apps communicate with each other, passing patient data through each stage of their care journey. 

<img width="842" alt="Screenshot 2024-10-03 at 21 47 00" src="https://github.com/user-attachments/assets/b903f0e9-2309-4d78-80d1-8319d0c24f84">

## Microservice Architecture
This project adopts a microservice architecture, where each service operates independently, interacting with others through APIs to form a decentralized patient management system.


## Web Applications
The system is composed of the following microservices:

1. **Admission**: Assigns the patient a unique identifier using `java.util.UUID` and forwards this data to the Diagnoses service.
   
2. **Diagnoses**: Evaluates patient symptoms and provides a diagnosis, forwarding this information to the Treatments service.

3. **Treatments**: Assigns the appropriate treatment to the patient and forwards the details to the Accountancy service.

4. **Accountancy**: Generates and provides the patient with an invoice for hospital services rendered.

5. **Administration**: Offers a user interface for admitting patients and allows accountants to manage patient invoices.

## Microservices Details
### 1. Admission Service (Port: 9001)
- Assigns UUIDs to patients upon admission.
- Forwards admitted patients to the Diagnoses service.
- **Endpoints**:
  - `POST /patients`: Admit a patient and assign a UUID.
  - `GET /uuids`: Retrieve all cached patient names and UUIDs.
  - `GET /uuids/{patientName}`: Retrieve a specific UUID.

### 2. Diagnoses Service (Port: 9002)
- Diagnoses patients based on symptoms.
- Forwards diagnosed patients to the Treatments service.
- **Endpoints**:
  - `POST /patients`: Diagnose a patient.

### 3. Treatments Service (Port: 9003)
- Assigns treatments and saves them in a NoSQL database.
- Forwards treated patients to the Accountancy service.
- **Endpoints**:
  - `POST /patients`: Provide treatment.
  - `GET /treatments`: Retrieve all treatments.

### 4. Accountancy Service (Port: 9004)
- Generates and manages invoices for treated patients.
- **Endpoints**:
  - `POST /patients`: Generate invoice.
  - `GET /invoices`: Retrieve all invoices.
  - `PUT /invoices/{id}/paid`: Mark an invoice as paid.

### 5. Administration Service (Port: 9000)
- Provides a central interface for managing patient admissions and tracking invoices. It integrates the functionalities of the other microservices, allowing hospital staff to admit patients, view their status through diagnosis and treatment, and manage financial records.
- **Endpoints**:
  - `POST /admissions`: Admit a new patient.
  - `GET /patients`: Retrieve a list of all admitted patients.
  - `GET /invoices`: View and manage invoices.
  
This service could be extended with a graphical user interface (GUI) in the future for easier management.


## Topics Covered
Each web application demonstrates an essential backend concept:

- **Bean Injection**
- **Property Files**
- **Web Communication**
- **NoSQL Databases**
- **SQL Databases**
- **Security**

## Technologies
- **Java Spring Boot**
- **MySQL/MongoDB**
- **Spring Security**
- **JUnit and Mockito tests**


## Prerequisites & Setup
- **JDK 17++** (Java Development Kit)
- **Docker** (for running MySQL and MongoDB databases)
- **Maven** (for dependency management and project building)
- **Spring Boot**

#### Docker Setup for MySQL and MongoDB

Ensure that Docker is installed on your system. You can use Docker containers to run MySQL and MongoDB databases for this project.

##### 1. MySQL (for Accountancy Service)
Run the following command to set up MySQL:

```bash docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mysql mysql:5.7```
This command pulls and runs the MySQL container, exposing it on port 3306 with the root password set to root.

##### 2. MongoDB (for Treatments Service)
Run the following commands to set up MongoDB and a UI for easy database interaction:
Create a Docker network for MongoDB and its UI
```docker network create mongo```

Run the MongoDB container
```docker run -d -p 27017:27017 --network mongo --name mongo mongo```

Run the MongoDB-Express UI container
```docker run -d -p 8081:8081 --network mongo --name mongoui mongo-express```


MongoDB will be available at ```localhost:27017```, and the UI will be accessible at ```http://localhost:8081```

