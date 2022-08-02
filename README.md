ROBOT APOCALYPSE
A Java REST API sample using Spring Boot,JPA, H2 DB, Maven. Implementing the problem described in given
PDF.

Frameworks and tools used
For this project I decided to use Spring Boot because it makes taking your project from the ground up a lot faster. 
And time was an important thing I took into consideration due to the short amount of time I had to focus on this project. 
Also used JPA H2Db(In memory) to handle most of the repository work.

H2 DB was selected because H2 is open source and written in Java. It supports standard SQL and JDBC API
It has embedded and Server mode.

End-Points Description
Here follows a list of the end-points by type of data that is returned.

The base URL to all end-points is:
/apocalypse/

. Survivor
The following end-points for survivor make use of the same fields here listed:

{
"survivorId": 0,
"name": "string",
"age": 0,
"gender": "string",
"location": {
"locationId": 0,
"latitude": 0,
"longitude": 0
},
"inventory": {
"inventoryId": 0,
"water": "string",
"food": "string",
"ammunitions": "string"
},
"reportedInfectionCount": 0
}
Request all of the survivors in the data-base
GET /survivors

CURL Example

curl -X 'GET' \
'http://localhost:8080/apocalypse/survivors/' \
-H 'accept: */*'

HTTP request example

http://localhost:8080/apocalypse/survivors/

Example Response 200 OK
[
{
"survivorId": 3,
"name": "Garima",
"age": 32,
"gender": "Female",
"location": {
"locationId": 2,
"latitude": -49.264789,
"longitude": -16.686882
},
"inventory": {
"inventoryId": 1,
"water": "test",
"food": "test",
"ammunitions": "test"
},
"reportedInfectionCount": 0
}
]

Creates a new Survivor

POST /survivors

Curl example

curl -X 'POST' \
'http://localhost:8080/apocalypse/survivors/' \
-H 'accept: */*' \
-H 'Content-Type: application/json' \
-d '{
"survivorId": 0,
"name": "Garima",
"age": 32,
"gender": "Female",
"location": {
"locationId": 0,
"latitude": -49.264789,
"longitude":-16.686882
},
"inventory": {
"inventoryId": 0,
"water": "test",
"food": "test",
"ammunitions": "test"
},
"reportedInfectionCount": 0
}'

HTTP request example

http://localhost:8080/apocalypse/survivors/
Request body

{
"survivorId": 0,
"name": "Garima",
"age": 32,
"gender": "Female",
"location": {
"locationId": 0,
"latitude": -49.264789,
"longitude":-16.686882
},
"inventory": {
"inventoryId": 0,
"water": "test",
"food": "test",
"ammunitions": "test"
},
"reportedInfectionCount": 0
}

Example Response 201 CREATED

Report an infected survivor

PUT /survivors/{id}/report

Curl example

curl -X 'PUT' \
'http://localhost:8080/apocalypse/survivors/{survivorId}/report?survivorId=3' \
-H 'accept: */*'

HTTP request example

http://localhost:8080/apocalypse/survivors/{survivorId}/report?survivorId=3

Example Response 201 reported

Updates a survivor location

Curl example

PATCH /survivors/{id}/location
curl -X 'PATCH' \
'http://localhost:8080/apocalypse/survivors/3/location/' \
-H 'accept: */*' \
-H 'Content-Type: application/json' \
-d '{
"latitude": 27.2046,
"longitude": 77.4977
}'
HTTP request example

http://localhost:8080/apocalypse/survivors/1/location/
Example Response 201 updated

.Reports
 The following end-points are used to obtain stats and reports about the survivors.

Get report on percentage of infected survivors

GET /report/infected

Curl example

curl -X 'GET' \
'http://localhost:8080/apocalypse/report/infected' \
-H 'accept: */*'

HTTP request example

http://localhost:8080/apocalypse/report/infected

Example Response 200 OK


Get report on percentage of non infected survivors

GET /report/nonInfected

Curl example

curl -X 'GET' \
'http://localhost:8080/apocalypse/report/nonInfected' \
-H 'accept: */*'

HTTP request example

http://localhost:8080/apocalypse/report/nonInfected

Example Response 200 OK


.ROBOT
 The following end-points for robot make use of the same fields here listed:
{
"id": 0,
"model": "0M3DZ",
"serialNumber": "1U74R28W8Q8X1T8",
"manufacturedDate": "2022-08-01T18:20:40.142Z",
"category": "Land"
}

Creates a new Robot

POST/robots/

Curl example

curl -X 'POST' \
'http://localhost:8080/apocalypse/robots' \
-H 'accept: */*' \
-H 'Content-Type: application/json' \
-d '{
"id": 0,
"model": "0M3DZ",
"serialNumber": "1U74R28W8Q8X1T8",
"manufacturedDate": "2022-08-01T18:20:40.142Z",
"category": "Land"
}'

HTTP request example

http://localhost:8080/apocalypse/robots

Request body

{
"id": 0,
"model": "0M3DZ",
"serialNumber": "1U74R28W8Q8X1T8",
"manufacturedDate": "2022-08-01T18:20:40.142Z",
"category": "Land"
}

Example Response 201 CREATED


Request all of the robots  in the data-base
GET /robots

CURL Example

curl -X 'GET' \
'http://localhost:8080/apocalypse/robots' \
-H 'accept: */*'

HTTP request example

http://localhost:8080/apocalypse/robots

Example Response 200 OK

Response body
Download
[
{
"id": 1,
"model": "0M3DZ",
"serialNumber": "1U74R28W8Q8X1T8",
"manufacturedDate": "2022-08-01T18:20:40.142+00:00",
"category": "Land"
}
]

















