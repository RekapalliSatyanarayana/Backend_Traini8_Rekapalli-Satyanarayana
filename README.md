# Backend_Traini8_Rekapalli-Satyanarayana

This project is an MVP for a registry of government-funded training centers, built using Spring Boot. It includes two main APIs: one for creating a new training center and another for retrieving all stored training centers.

Setup Instructions
Clone the Repository:

git clone cd Traini8MVP

Build the Project:

Ensure you have Maven and JDK 11 installed. Run the following commands: sh mvn clean install

Run the Application:
Start the Spring Boot application:

sh mvn spring-boot:run

The application will start on port 8081.

Access the H2 Console:
Open your web browser and navigate to http://localhost:8081/h2-console.

Use the following credentials:

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (leave it blank)

API Documentation POST /api/training-centers Description: Create and save a new training center.

URL: http://localhost:8081/api/training-centers

Method: POST

Request Body: { "centerName": "IT Job Courses", "centerCode": "IT3738373325", "address": { "detailedAddress": "388 Ameerpet", "city": "Hyderabad", "state": "Telangana", "pincode": "5300016" }, "studentCapacity": 120, "coursesOffered": ["Java", "ReactJs", "Springboot"], "contactEmail": "contact@itjobcourses.com", "contactPhone": "3984567321" }

Response: Returns the newly saved training center information.

GET /api/training-centers Description: Retrieve all stored training centers.

URL: http://localhost:8081/api/training-centers

Method: GET

Response: Returns a list of training centers in JSON format.

DELETE /api/training-centers/{id} Description: Delete a training center by ID.

URL: http://localhost:8081/api/training-centers/{id}

Method: DELETE

Response: Returns no content if successful, or not found if the ID does not exist.

Filtering (Optional) GET /api/training-centers?city=Metropolis: Filter by city

GET /api/training-centers?state=Andhra Pradesh: Filter by state

Example Usage: POST: Use Postman or another API testing tool to send a POST request to http://localhost:8081/api/training-centers with the request body as shown above.

GET: Use your browser or Postman to send a GET request to http://localhost:8081/api/training-centers.

DELETE: Use Postman to send a DELETE request to http://localhost:8081/api/training-centers/1.

Database Access: Access the H2 console at http://localhost:8081/h2-console to view the database.

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: Leave blank (unless set in application.properties)
