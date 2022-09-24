# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/gradle-plugin/reference/html/#build-image)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## Install MongoDB locally on Mac
1. Download MongoDB [MongoDB Community Server](https://www.mongodb.com/try/download/community)
![image](https://user-images.githubusercontent.com/26097904/192107786-ec1bce0d-c620-4f3d-b11c-f2e0dbdee49a.gif)

2. Setup MONGO_HOME environment variable
![image](https://user-images.githubusercontent.com/26097904/192107815-ac2694b8-e7eb-477d-a2a8-a19d894bb22d.gif)

3. Check mongo version in command prompt/Terminal
> mongo --version
![image](https://user-images.githubusercontent.com/26097904/192107872-6471fd0b-f417-4c86-b996-9245a1d9656b.gif)

4. Setting Database Server : Create a folder or directory which will store all the data processed by the mongod

> mongod --dbpath /Users/sovanmukherjee/dev/Software/mongodb
![image](https://user-images.githubusercontent.com/26097904/192108287-d77b6154-170c-44dc-8652-0062d9d79458.gif)

5. Install mongoDb [Compass](https://www.mongodb.com/try/download/compass2) to see collection and data 
![image](https://user-images.githubusercontent.com/26097904/192108339-3783e771-c457-43c8-afff-bcb07d0f20a3.gif)

 After installation open MongoDB Campass
 ![image](https://user-images.githubusercontent.com/26097904/192108361-44447a9a-4d3f-4a5c-b373-feb60279d54a.gif)
 
6. Click on Fill in connection fields
![image](https://user-images.githubusercontent.com/26097904/192108381-4b7f4c30-4163-41e1-977e-5040411d9775.gif)

7. Provide all required information and click on connect
![image](https://user-images.githubusercontent.com/26097904/192108524-96e68c17-5862-4f15-9a1a-1ce11f323397.gif)

![image](https://user-images.githubusercontent.com/26097904/192108539-ffa5f9c5-1b9c-4429-9cae-9517df0fae13.gif)

8. You can create database and Collection manually
<img width="1267" alt="image" src="https://user-images.githubusercontent.com/26097904/192108888-d551ed51-408d-4ea9-9468-7f164acdd472.png">

![image](https://user-images.githubusercontent.com/26097904/192108590-0cba787b-4d0b-419e-aff2-656200a6dd61.gif)

9. Check all databases through command prompt
 > mongo
 
 > show dbs
![image](https://user-images.githubusercontent.com/26097904/192108618-2d3dce7c-193e-4685-a786-3708f614e787.gif)

10. Use database with database name

Syntax: use  <DB_NAME>
![image](https://user-images.githubusercontent.com/26097904/192108644-62761f9f-7fe6-40be-8cba-41d418a12484.gif)


11. Create index

Syntax: db.COLLECTION_NAME.createIndex({KEY:1})
> db.student.createIndex({"crTime": 1})

12. View index

Syntax: db.COLLECTION_NAME.getIndexes()
> db.student.getIndexes()

![image](https://user-images.githubusercontent.com/26097904/192108683-86528143-7f9b-4337-a330-e7ee8c18e9f6.gif)

## Add TTL on mongoDB

1. create TTL Index

Syntax: db.COLLECTION_NAME.createIndex({"KEY": 1},{expireAfter: "3600s"})

-OR - 

db.COLLECTION_NAME.createIndex( { "KEY": 1 }, { expireAfterSeconds: 3600 } )

Example: db.student.createIndex({"crTime": 1},{expireAfter: "3600s"})

<img width="1276" alt="image" src="https://user-images.githubusercontent.com/26097904/192109906-df49cbda-a624-46a3-8570-1265bab36ebe.png">

## Run Application

Local Swagger UI: http://localhost:8080/swagger-ui/index.html
<img width="1458" alt="image" src="https://user-images.githubusercontent.com/26097904/192110061-be0ae4a3-8d87-45db-813b-05f80f8b9c72.png">

> Save Student
<img width="1444" alt="image" src="https://user-images.githubusercontent.com/26097904/192110150-bb4545c5-7db5-4662-b74c-38697ffd18a8.png">
You can check data in Compass
<img width="1279" alt="image" src="https://user-images.githubusercontent.com/26097904/192110206-dba6afb2-c22d-4942-9d8e-1a96d848c619.png">
<img width="1283" alt="image" src="https://user-images.githubusercontent.com/26097904/192110758-8d7ad312-1e4d-4cab-9214-9dc4184a885c.png">

> Get Students By className

Request payload
<img width="1437" alt="image" src="https://user-images.githubusercontent.com/26097904/192110421-1576324c-fd7c-411c-b797-3461261075b7.png">
Response payload

```
{
  "content": [
    {
      "id": "1971a4ab-5226-4f81-b3fc-ffde69aa8277",
      "rollNumber": 1,
      "contact": {
        "emailId": "xxxx@gmail.com",
        "mobile": "9999999999"
      },
      "vsningFlds": {
        "createdBy": "abc",
        "crTime": "2022-09-24T22:34:11.826"
      }
    },
    {
      "id": "cdb5d2e7-36ee-40c8-bc66-6eefa5b7d503",
      "rollNumber": 2,
      "contact": {
        "emailId": "xxxx@gmail.com",
        "mobile": "9999999999"
      },
      "vsningFlds": {
        "createdBy": "abc",
        "crTime": "2022-09-24T22:37:47.863"
      }
    },
    {
      "id": "a3fc979f-3835-4e19-a374-8ca849711144",
      "rollNumber": 3,
      "contact": {
        "emailId": "xxxx@gmail.com",
        "mobile": "9999999999"
      },
      "vsningFlds": {
        "createdBy": "abc",
        "crTime": "2022-09-24T22:38:19.39"
      }
    },
    {
      "id": "db30ce97-d29b-437f-b754-15354ef8b861",
      "rollNumber": 4,
      "contact": {
        "emailId": "xxxx@gmail.com",
        "mobile": "9999999999"
      },
      "vsningFlds": {
        "createdBy": "abc",
        "crTime": "2022-09-24T22:39:24.644"
      }
    },
    {
      "id": "c71bc980-1476-474f-a709-43bd1a28f20a",
      "rollNumber": 5,
      "contact": {
        "emailId": "xxxx@gmail.com",
        "mobile": "9999999999"
      },
      "vsningFlds": {
        "createdBy": "abc",
        "crTime": "2022-09-24T22:39:50.437"
      }
    }
  ],
  "pageable": {
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 10,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 5,
  "first": true,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "numberOfElements": 5,
  "empty": false
}
```

