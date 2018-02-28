# ridecell-parkingspot
The RideCell parking spot assignment

This is an attempt to solve the problem statement given below:
Assume that we are building a street parking spot reservation service. Each parking spot is identified by its location (lat, lng). Users should be able to view street parking spots, reserve and pay for the parking spots or cancel their reservations. Build REST API's for the following and share the github repository with us.  You can populate your database with any dummy data you want. 


Requirements
	•	See available parking spots on a map
	•	Search for an address and find nearby parking spot. (input: lat, lng, radius in meters. Output - list of parking spots within the radius).
	•	Reserve a parking spot
	•	View existing reservations
	•	Cancel an existing reservation
	•	Show the user the cost of the reservation
Bonus
	•	Automated tests
	•	Require users to use phone numbers to sign up.
	•	Validate that the phone numbers are real.
	•	Additional features (whatever you think would be useful.)
  
  ===============================================================================================
  Solution:
  
  This is implemented as a RESTful API using:
  Java
  Jersey which is a JAX-RS implementation to build REST endpoints
  MySQL
  JDBC
  
  The project uses Maven build system and the codebase is exposed as microservice using Executable JAR.
  One can use mvn exec:java to quickly runt and test the APIs or one case run:
  mvn clean package
  It will produce executable JAR named: parking-assistant-0.0.1-SNAPSHOT-jar-with-dependencies.jar
  which can be executed as: java -jar parking-assistant-0.0.1-SNAPSHOT-jar-with-dependencies.jar
  
  Jetty is used as an embedded HTTP container to server RESTful APIs and it runs on 8080.
  So one can access it like: http://localhost:8080
  
  The endpoints in line:
 A. Parking spot resource:
  
  1. /parkings
  http://localhost:8080/parkings
  GET
  Get all parkings - both available and reserved
  Response:
  [
    {
        "address": "Teerth techspace",
        "id": 2,
        "latitude": 73.77,
        "longitude": 0
    },
    {
        "address": "Varanda resto",
        "id": 3,
        "latitude": 73.75,
        "longitude": 0
    },
    {
        "address": "Agent jack",
        "id": 4,
        "latitude": 73.73,
        "longitude": 0
    },
    {
        "address": "Teddy boy",
        "id": 5,
        "latitude": 73.71,
        "longitude": 0
    },
    {
        "address": "Yaara di haveli",
        "id": 6,
        "latitude": 73.69,
        "longitude": 0
    }
]
  
  2./parkings/available
  http://localhost:8080/parkings/available
  GET
  Get all available parkings
  Response:
  [
    {
        "address": "Varanda resto",
        "id": 3,
        "latitude": 73.75,
        "longitude": 0
    },
    {
        "address": "Agent jack",
        "id": 4,
        "latitude": 73.73,
        "longitude": 0
    },
    {
        "address": "Teddy boy",
        "id": 5,
        "latitude": 73.71,
        "longitude": 0
    },
    {
        "address": "Yaara di haveli",
        "id": 6,
        "latitude": 73.69,
        "longitude": 0
    }
]
  
  3./parkings/reserved
  http://localhost:8080/parkings/reserved
  Get all reserved parkings
  Response:
  [
    {
        "address": "Teerth techspace",
        "id": 2,
        "latitude": 73.77,
        "longitude": 0
    }
]
  
  4./parkings/search
  http://localhost:8080/parkings/search
  POST
  Helps find all the parking spot at given lat, long in a given radius
  Request:
  {
  "latitude":18.55,
  "longitude":73.77,
  "radius":10
  }
  Response:
  [
    {
        "address": "Teerth techspace",
        "id": 2,
        "latitude": 18.55,
        "longitude": 73.77
    },
    {
        "address": "Varanda resto",
        "id": 3,
        "latitude": 18.5,
        "longitude": 73.75
    }
]
  
  For bookings, a User resource related API could have been created which will take care of
  Signup, Login etc. but running late.
  Using which, all auth etc. could have been done and all the requests will be processed in context of logged in user.
  
  B. Bookings or reservations resource
  
  1./bookings
  http://localhost:8080/bookings
  POST
  Create a reservation for a parking spot
  Request:
  {
  "parkingSpotId":2,
  "userId":1
}
Response: Status 201
{
    "cost": 100,
    "id": 6,
    "parkingSpotId": 2
}

2./bookings
DELETE
http://localhost:8080/bookings/{bookingId} e.g. http://localhost:8080/bookings/4
Response:
200


