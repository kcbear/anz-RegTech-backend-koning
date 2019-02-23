Required JDK 8+

# To build
./gradlew build

# To run the jar:
java -jar build/libs/anz-RegTech-backend-koning-1.0.0.jar

# Description
After run the jar and started the application, a tomcat web server will be started with port 8080.
application.log file is created in the current directory after started.
This spring boot application as backend service exposes 2 rest API services and return JSON response

    1. http://localhost:8080/accounts/
    2. http://localhost:8080/transactions/{accountNumber}

Mocking database data is pre-loaded during startup.

Example:

    listing accounts:       http://localhost:8080/accounts/

    listing transactions:   http://localhost:8080/transactions/1001
