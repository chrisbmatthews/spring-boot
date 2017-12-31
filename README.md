# spring-boot-mysql

Examples of spring-boot sitting on top of mysql with proper transaction management provided by Atomikos

This also demonstrates:
* spring-boot's CommandLineRunner
* JPA and injection of an EntityManager
* Unit testing using an in-memory H2 database

Install mysql onto your system.
Then login as root and run the script in /config/db-setup.sql
This will create a new database called 'springbootmysql', and a user named springbootmysql (password is 'password')

If you look at the application.properties file for this application, you will find the login credentials for the database baked in:

```
spring.datasource.url= jdbc:mysql://localhost:3306/springbootmysql
spring.datasource.username=springbootmysql
spring.datasource.password=password
```

(you can change those if you are running mysql on a different port, for example)