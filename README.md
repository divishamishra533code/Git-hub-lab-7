# Course Management API – CRUD Operations using ResponseEntity

## Overview

This project is a Spring Boot REST API that demonstrates full CRUD (Create, Read, Update, Delete) operations on course data using `ResponseEntity`. It simulates a university backend system where administrators can manage course details efficiently while ensuring proper HTTP status codes and structured responses.

## Features

* Add a new course
* Update existing course details
* Delete a course by ID
* Retrieve all courses
* Retrieve a course by ID
* Search courses by title
* Proper HTTP status handling using ResponseEntity

## Technologies Used

* Java
* Spring Boot
* Spring Web (REST API)
* Maven

## Project Structure

```
course-api/
 ├── src/main/java/com/example/courseapi/
 │    ├── CourseApiApplication.java
 │    ├── controller/
 │    │      └── CourseController.java
 │    ├── service/
 │    │      └── CourseService.java
 │    ├── model/
 │    │      └── Course.java
 └── pom.xml
```

## Course Entity

Fields:

* courseId (int)
* title (String)
* duration (String)
* fee (double)

## API Endpoints

### Create Course

* Method: POST
* URL: `/courses`
* Description: Adds a new course
* Response:

  * 201 CREATED (success)
  * 400 BAD_REQUEST (invalid input)

### Get All Courses

* Method: GET
* URL: `/courses`
* Response:

  * 200 OK

### Get Course by ID

* Method: GET
* URL: `/courses/{id}`
* Response:

  * 200 OK (found)
  * 404 NOT_FOUND (if course does not exist)

### Update Course

* Method: PUT
* URL: `/courses/{id}`
* Response:

  * 200 OK (updated)
  * 404 NOT_FOUND

### Delete Course

* Method: DELETE
* URL: `/courses/{id}`
* Response:

  * 200 OK (deleted)
  * 404 NOT_FOUND

### Search Course by Title

* Method: GET
* URL: `/courses/search/{title}`
* Description: Returns courses matching given title
* Response:

  * 200 OK
  * 404 NOT_FOUND (if no match)

## Sample Request (POST /courses)

```json
{
  "courseId": 1,
  "title": "Full Stack Development",
  "duration": "6 Months",
  "fee": 25000
}
```

## Sample Responses

### Success (Created)

```json
{
  "message": "Course added successfully"
}
```

### Error (Not Found)

```json
{
  "message": "Course not found"
}
```

## How to Run

1. Clone the repository:

```
git clone https://github.com/your-username/course-api.git
```

2. Navigate to project:

```
cd course-api
```

3. Run the application:

```
mvn spring-boot:run
```

4. Access base URL:

```
http://localhost:8080
```

## Testing

Use API testing tools like Postman to test:

* Valid inputs
* Invalid inputs
* Edge cases (non-existing IDs)

## Notes

* Data is stored in-memory and will reset on restart.
* ResponseEntity ensures proper HTTP communication between client and server.
* This project is intended for academic use.

## Author

Divisha Mishra
