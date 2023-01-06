# About project
This project provide auth backend service for TrinityCore:

* Account data

# Getting Started

### Reference Documentation
* Copy file resources/application.properties-example and rename it into resources/application.properties
* Fill in the config-file all required database information

### Compile
* mvn clean package
* fill OS environment variables SPRING_PROFILES_ACTIVE=dev (dev or prod or any else)
* Run package (java -jar authbackend/target/AuthBackend-0.1.jar)