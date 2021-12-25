# Market

## Step by step guide


### First of all, we need to create database for our application
##### Command to create proper database: ```CREATE DATABASE emarket CHARACTER SET utf8 COLLATE utf8_general_ci;```
##

### Now we should to create folder for our application
##
### Than we are download .jar file from [there](https://github.com/empty-person/Market/blob/master/target/Market-0.0.1-SNAPSHOT.jar), and put it in created folder

### In folder we should create a new file with name application.properties and put inside the following code
 
- spring.datasource.username and spring.datasource.password should contain your data 

``` 
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/emarket
spring.datasource.username=root
spring.datasource.password=12345
spring.datasource.driver-class-name =com.mysql.jdbc.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect



spring.datasource.initialization-mode=always
spring.datasource.continue-on-error=true
```

##
### Well, now we need to start our application
#### Open command prompt and type command below with adjusted values
`
You should change Market-0.0.1-SNAPSHOT.jar with location of downloaded jar 
You should change C:\Me\IncredibleFolder\application.properties to path from the application.properties which we are created above
`
##### Command to run application on localhost: ```java -jar Market-0.0.1-SNAPSHOT.jar --spring.config.location=file:C:\Me\IncredibleFolder\application.properties --server.port=8083```
##


## Endpoint URLs for each business scenario with needed body
### Guide
{} = body with example values where :
```diff
+ green line means value SHOULD BE INCLUDED IN BODY REQUEST
# gray line means value ALLOWED TO NOT BEING INCLUDED
```

## 

### Create new item(product) 
```diff
  Post request
  http://localhost:8080/item {
+   "name":"itemName12",
+   "price":22.2
    }
```


### Get item(product) by name  [example](https://i.ibb.co/WFt8CdQ/image.png)
```diff
  Get requst
  http://localhost:8080/item {
+   item name
    }
```

### Get all items [example](https://i.ibb.co/jLkLgtC/image.png)
```diff
  Get request
  http://localhost:8080/item/all
```

### Create new user(basket holder) [example](https://i.ibb.co/NT3bpPW/image.png)
```diff
  Post request
  http://localhost:8080/user {
+   "username":"username1",
+   "password":"password",
+   "money":222.22
    }
```

### Get user by id [example](https://i.ibb.co/89QNm2y/image.png)
```diff
  Get request
  http://localhost:8080/user/2
```

### Get all users [example](https://i.ibb.co/NsVxXPp/image.png)
```diff
  Get request
  http://localhost:8080/user/all
```

### Add item to basket [example](https://i.ibb.co/vqQmM6W/image.png)
```diff
  Post request
  http://localhost:8080/basket/add {
+   "itemName":"itemName",
#   "userName":"userName1",                                (default value = username1)
#   "quantity":2                                           (default value = 1)
    }
```

### Remove item from basket [example](https://i.ibb.co/r76hnB8/image.png)
```diff
  Post request
  http://localhost:8080/basket/remove {
+   "itemName":"itemName12",
#   "quantity":3,                                          (default value = 1)
#   "userName":"dssfg"                                     (default value = username1)
    }
```

### Get basket by username [example](https://i.ibb.co/zbh7FS4/image.png)
```diff
  Get request
  http://localhost:8080/basket{
+  "userName":"userName1"
  }
```

### Complete order for user [example](https://i.ibb.co/Hq8Kgbb/image.png)
```diff
  Post request
  http://localhost:8080/order/complete {
#   "userName":"username21"                                     (default value = username1)
    }
```

### Retrieve order history for user [example](https://i.ibb.co/RzpZPvB/image.png)
```diff
  Post request
  http://localhost:8080/order/complete {
#   "userName":"username21"                                     (default value = username1)
    }
```







