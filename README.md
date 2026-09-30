# Online Hall Booking - Java + JDBC

## Requirements
- JDK 17+
- Maven
- MySQL 8+
- Apache Tomcat 10.1+

## Database
Run `database/schema.sql` in MySQL.

Then update the username/password in:
`src/main/java/com/hallbooking/util/DBConnection.java`

## Run
`mvn clean package`

Deploy `target/hall-booking.war` to Tomcat 10.1+ and open:
`http://localhost:8080/hall-booking/`

This starter demonstrates registration, login, hall listing and booking with JDBC.
