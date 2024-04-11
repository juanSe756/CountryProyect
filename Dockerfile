FROM maven:3.8.3-openjdk-17
ARG GIT_USER=juanSe756
ARG GIT_TOKEN=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

RUN mvn clean package

CMD ["bash", "-c", "java -jar target/CountryProyect-0.0.1-SNAPSHOT.jar & java -jar target/CountryProyect-0.0.1-SNAPSHOT.jar"]