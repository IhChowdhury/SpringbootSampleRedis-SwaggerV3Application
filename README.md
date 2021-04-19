# SpringbootSampleRedis-SwaggerV3Application
A sample spring boot application using Redis and Swagger v3

## Dependies Uses

###### For Redis
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        
###### For Swagger v3 (Open API specification)

        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-ui</artifactId>
            <version>1.5.2</version>
        </dependency>
        
Download Redis to setup server from this [link](https://redis.io/download)

After downloading redis, Unzip it and keep it in any driver. open Redis folder you will find redis-server.exe. Double click it and it will open server on its default port 6379.

## How to run this application
To run this application follow this steps

  - Clone this project and open it in any IDE like STS, intelliJ IDEA, VsCode etc. 
  - Now Run the application. It will run 3232 port. 
  - Now open postman to test Rest apis
    * To save data send a post request to *http://localhost:3232/api/product*
    * To see saved data send get request to *http://localhost:3232/api/product*
  - Now close the application and send the get request again to see saved data available or not. You can see previous saved  data because it was stored in redis.
