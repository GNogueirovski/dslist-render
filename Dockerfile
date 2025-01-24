FROM maven:3.9.9-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-alpine

WORKDIR /app

COPY --from=build /app/target/dslist-1.0.jar ./dslist-1.0.jar

CMD ["java", "-jar", "dslist-1.0.jar"]