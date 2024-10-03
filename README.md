# Hospital Microservices - Backend Exercise Series

## Overview
This series of web applications is a decentralized system for the simplified management of patients within a hospital. The decentralized system consists of several web applications that communicate between each other in order to accomplish the main goal.

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


## Topics Covered
Each web application demonstrates an essential backend concept:

- **Bean Injection**
- **Property Files**
- **Web Communication**
- **NoSQL Databases**
- **SQL Databases**
- **Security**

