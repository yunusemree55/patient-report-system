# Patient Report System

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#tech-stack">Tech Stack</a>
    </li>
    <li>
      <a href="#installation">Installation</a>
    </li>
    <li>
      <a href="#dependencies">Dependencies</a>
    </li>
    <li>
      <a href="#api-usage">API Usage</a>
    </li>
    <li>
      <a href="#screenshoots">Screenshoots</a>
    </li>
  </ol>
</details>

## About The Project

The proposed Laboratory Reporting System is built using Spring Boot. This will be helpful for the laboratory workers to handle the patient's diagnosis reports efficiently. The proposed system will enable the lab technicians to:

- Adding new diagnosis reports for the patients.
- Update existing reports with new information or changes.
- Remove reports that are no longer needed.

## Tech Stack

- <picture>
    <img width=130 alt="Spring Boot" src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1200px-Spring_Framework_Logo_2018.svg.png">
  </picture>
- <picture>
    <img width=130 alt="Jpa" src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjlnf3vDICc1HZvO_sDAmRkjEW8XDjb84mrGWg56tNlgyQbnwGXqEZAzP1J3_xncxe1NP4-nZqlZZTzI4yr528A-dkJmC022gN4tJe-n8gwp2YoUiL-6ecV0BOiauQMstrFdyw8cBF3HHla/w1200-h630-p-k-no-nu/jpa.PNG">
  </picture>
- <picture>
    <img width=130 alt="Postman" src="https://upload.wikimedia.org/wikipedia/commons/c/c2/Postman_%28software%29.png">
  </picture>
- <picture>
    <img width=130 alt="PostgreSQL" src="https://png.pngitem.com/pimgs/s/467-4673213_connector-postgresql-colorlogo-postgres-logo-hd-png-download.png">
  </picture>
- <picture>
    <img width=130 alt="PostgreSQL" src="https://miro.medium.com/v2/resize:fit:1400/1*C_u3RtbZnYzRI10IUWbPfg.png">
  </picture>


## Installation

1. Clone The Repo

      ```sh
   git clone https://github.com/yunusemree55/patient-report-system.git
   ```
2. Enter Into Project Directory

      ```sh
   cd patient-report-system
   ```
3. Install Dependencies

   ```sh
   mvn clean install
   ```

4. Create Database
  
     ```sql
    CREATE DATABASE labdemo;
    ```

5. Configure Database Settings

   Open src/main/resources/application.properties and configure your database settings:
   
      ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/labdemo
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update

   ```
6. Run the App
   ```sh
   mvn spring-boot:run
   ```

7. Test the App
     ```sh
     http://localhost:8080/swagger-ui/index.html
     ```

## Dependencies

- **Lombok**: A tool that simplifies and cleans up code writing.
- **ModelMapper**: A tool that mapping objects.
- **Spring Security Crypto**: Security dependency for encryption operations.
- **ImageKit Java SDK**: To upload and manage images.
- **Spring Boot Starter Mail**: Spring Boot starter that provides the essential configuration for email sending.

## API Usage

 <details>
 <summary>Laborants</summary>

  ### 
  ```http
  GET /api/laborants
```
  
  ### Get All
  
  ```http
  GET /api/laborants/all
```
  
  
  ### Get By Id
  
  ```http
  GET /api/laborants/${id}
```
  
  | Parameters | Type     | Description                       |
  | :-------- | :------- | :-------------------------------- |
  | `id`      | `int` | **Required.** The key value of the laborant |
  
  
  ### Get By Name
  
  ```http
  GET /api/laborants/name
```
  
  | Query Parameters | Type     | Description                       |
  | :-------- | :------- | :-------------------------------- |
  | `firstName`      | `String` | **Required.** Laborant's first name |
  | `lastName`      | `String` | **Required.** Laborant's last name |


  ### Add
  
  ```http
  POST /api/laborants/add
```
  
  ```javascript
  {
    "firstName": "Yunus Emre",
    "lastName": "Flower",
    "username": "ye013",
    "email": "yunussemree_55@hotmail.com",
    "password": "123",
    "confirmPassword": "123"
  }
  ```
  
  | Fields | Type     | Description                       |
  | :-------- | :------- | :-------------------------------- |
  | `firstName`      | `String` | **Required.** Laborant's first name |
  | `lastName`      | `String` | **Required.** Laborant's last name |
  | `username`      | `String` | **Required.** Laborant's username |
  | `email`      | `String` | **Required.** Laborant's email |
  | `password`      | `String` | **Required.** The password for the laborant's account |
  | `confirmPassword`      | `String` | **Required.** A confirmation of the entered password. |
  
  ### Update Username
  
  ```http
  PUT /api/laborants/update-username
```
  
  ```javascript
  {
    "id": 1,
    "username": "example",
  }
  ```
  
  | Fields | Type     | Description                       |
  | :-------- | :------- | :-------------------------------- |
  | `id`      | `int` | **Required.** Laborant's id |
  | `username`      | `String` | **Required.** Laborant's new username |
  
  
  ### Update Password
  ```http
  PUT /api/laborants/update-password
```
  
  ```javascript
  {
    "id": 1,
    "password": "examplePassword",
    "confirmPassword": "examplePassword",
  }
  ```
  
  | Fields | Type     | Description                       |
  | :-------- | :------- | :-------------------------------- |
  | `id`      | `int` | **Required.** Laborant's id |
  | `password`      | `String` | **Required.** The password for the laborant's account |
  | `confirmPassword`      | `String` | **Required.** A confirmation of the entered password|

  
</details>

<details>
  <summary>Patients</summary>

###
  ```http
  GET /api/patients
```

### Get All

  ```http
  GET /api/patients/all
```


### Get By Id

  ```http
  GET /api/patients/${id}
```

| Parameters | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required.** The key value of the patient |


### Get By Identity Number

  ```http
  GET /api/patients/identity-number/${identityNumber}
```

| Parameters | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `identityNumber`      | `int` | **Required.** Identity number of the patient |



### Get By Name

  ```http
  GET /api/patients/name
```

| Query Parameters | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `firstName`      | `String` | **Required.** Patient's first name |
| `lastName`      | `String` | **Required.** Patient's last name |



### Add

  ```http
  POST /api/patients/add
```

```javascript
{
  "firstName": "Yunus Emre",
  "lastName": "Flower",
  "username": "example",
  "identityNumber":"12345678910"
  "email": "email@example.com",
  "password": "123",
  "confirmPassword": "123"
}
```

| Fields | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `firstName`      | `String` | **Required.** Patient's first name |
| `lastName`      | `String` | **Required.** Patient's last name |
| `username`      | `String` | **Required.** Patient's username |
| `identityNumber`      | `String` | **Required.** Patient's identity number |
| `email`      | `String` | **Required.** Patient's email |
| `password`      | `String` | **Required.** The password for the patient's account |
| `confirmPassword`      | `String` | **Required.** A confirmation of the entered password. |


### Update Username

  ```http
  PUT /api/patients/update-username
```

```javascript
{
  "id": 1,
  "username": "example",
}
```

| Fields | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required.** Patient's id |
| `username`      | `String` | **Required.** Patient's new username |


### Update Password

  ```http
  PUT /api/patients/update-password
```

```javascript
{
  "id": 1,
  "password": "examplePassword",
  "confirmPassword": "examplePassword",
}
```

| Fields | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required.** Patient's id |
| `password`      | `String` | **Required.** The password for the patient's account |
| `confirmPassword`      | `String` | **Required.** A confirmation of the entered password|

</details>

<details>
  <summary>Reports</summary>

  ###

  ```http
  GET /api/reports
```

### Get All

  ```http
  GET /api/reports/all
```


### Get By Id

  ```http
  GET /api/reports/${id}
```

| Parameters | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required.** The key value of the report |


### Get By Sorted Date

  ```http
  GET /api/reports/sorted-by-date
```

### Get By Active Reports

  ```http
  GET /api/reports/active-reports
```

### Get By Passive Reports

  ```http
  GET /api/reports/passive-reports
```

### Add

  ```http
  POST /api/reports/add
```

```javascript
{
    "laborantId": 1,
    "patientId": 1,
    "diagnosisTitle": "Flu",
    "description": "The patient shows symptoms of a fever, cough, and sore throat, indicative of the flu."
}
```

| Fields | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `laborantId`      | `int` | **Required.** Laborant's id |
| `patientId`      | `int` | **Required.** Patient's id |
| `diagnosisTitle`      | `String` | **Required.** Title of diagnosis |
| `description`      | `String` | **Required.** Description of diagnosis |


### Update Report

  ```http
  PUT /api/patients/update-report
```

```javascript
{
    "id": 1,
    "diagnosisTitle": "Pneumonia",
    "description": "The patient is diagnosed with bacterial pneumonia, showing symptoms of chest pain and shortness of breath."
}
```

| Fields | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `patientId`      | `int` | **Required.** Report's id |
| `diagnosisTitle`      | `String` | **Required.** Title of diagnosis |
| `description`      | `String` | **Required.** Description of diagnosis |


### Delete By Id

  ```http
  DELETE /api/reports/delete/${id}
```

| Parameters | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required.** The key value of the report |
</details>

<details>
  <summary>Photos</summary>
 
  ###
  
  ```http
  GET /api/photos
```

### Add

  ```http
  POST /api/photos/add
```



| Fields | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `reportId`      | `int` | **Required.** Report's id 
| `file`      | `MultipartFile` | **Required.** Report photo |
</details>

## Screenshoots

![Swagger](https://github.com/user-attachments/assets/34417cdd-3297-4661-a2c4-c6d5f1fcd949)
