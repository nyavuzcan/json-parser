# APX market data parser
- It has json file read.
- It has some validations and save db.

## Requirements
Firstly, Postgresql database is used in the project. So a new database should be created according to the following information:

- Jdk 1.8

- Gradle 3.1

- Postgresql 


## Setup And Run

-You need to edit the application properties file according to your own db information.

- After you can use app.

- You can change input in apx-data.json file. You have to use json format.
## Endpoints:

 **Swagger:** http://localhost:8080/swagger-ui.html#

 **SpringBoot Api:** http://localhost:8080
 
 **All Quotes in Order *Preferred :** localhost:8080/ivx/inquireQuotes  -GET METHOD
 
 **All Quotes :** localhost:8080/ivx/getQuotes  -GET METHOD
 
 **Save All Quotes to PostgreSql Pt :** localhost:8080/ivx/saveAllQuotes  -GET METHOD

## Used technologies
**SpringBoot:** For api.

**Write/Read Files:** Reading all data from json file and save pt.

**Swagger:** All endpoints are easily schematized.



