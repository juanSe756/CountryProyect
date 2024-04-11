FROM maven:3.8.3-openjdk-17

RUN mvn clean package


CMD ["bash", "-c", "java -jar target/CountryProyect-0.0.1-SNAPSHOT.jar & java -jar target/CountryProyect-0.0.1-SNAPSHOT.jar"]