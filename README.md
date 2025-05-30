# testIntcomex
technical test Intcomex

This project is a practical example of developing a REST API .

### Required Technologies
`Java 17` `Maven`

### :wrench: Configuration
1.  context
   
   ```java
   package com.technicaltest;
   ```

   2. Application.properties
   1. JPA & MYSQL
   ```properties
 spring.datasource.url=jdbc:mysql://products.chmeuscgam28.sa-east-1.rds.amazonaws.com:3306/products?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false

#Usuario y contrasena
spring.datasource.username=root
spring.datasource.password=Ifv.891123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql = true
```

### : Execution
1. Deploy the project locally:: `> mvn clean install`
   
2. ### :Documentation swagger
 http://15.229.9.242/swagger-ui/index.html#/

### : Endpoints
### post
http://15.229.9.242/Category/
### post
http://15.229.9.242/Product/
### Get
http://15.229.9.242/Products/
### Get
http://15.229.9.242/Products/id/



### : Testing
1. Run unit tests: `> mvn test``
