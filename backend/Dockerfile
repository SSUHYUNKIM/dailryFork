FROM openjdk:17-alpine

ARG JAR_FILE=/build/libs/da-ily-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /da-ily-0.0.1-SNAPSHOT.jar

ENTRYPOINT [
"java",
"-jar",
"-Dspring.profiles.active=prod",
"/da-ily-0.0.1-SNAPSHOT.jar"]