## coup-api

### API documentation

http://localhost:8080/swagger-ui.html

### Run application
```sh
mvn spring-boot:run
```

### Testing

Run all tests with:

```sh
mvn clean test
```

### To make a post request using curl

Example: 
```
curl -H "Content-Type: application/json" -X POST -d '{"scooters": [14, 15, 12], "C": 12, "P": 5}' http://localhost:8080/coup-api/fleet-engineers-required
```
