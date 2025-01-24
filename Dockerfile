FROM eclipse-temurin:17-alpine

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/dslist-1.0.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

LABEL authors="Gabriel"