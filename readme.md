### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.


#### Code enhancement of this project

* Add log related properties in application.properties and replace System.out with logger in the code

* Remove the `setEmployeeRepository` & `setEmployeeService` methods in EmployeeController and EmployeeService:  

* Change `saveEmployee`'s url from /employees to /employees/save

* Use `lombok.Data` and then remove `lombok.Setter` and `lombok.Getter`

* When invoke method to delete employee, use update status to DELETED rather than actually delete
the record in Database.

* Add dependency of spring-security to access the APIs (Cancelled, fow now I haven't solved the cors problem when using swagger)

* Add API description in Swagger

* Simple caching sample for database calls in EmployeeRepository

#### My experience in Java

I have 4+ years experience in both in Java and Spring boot.
I know Spring Boot very well and have been using it for many years.
