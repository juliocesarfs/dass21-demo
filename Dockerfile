FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests
RUN mvn package

FROM openjdk:17-jdk-slim

EXPOSE 8081

COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar app.jar

RUN javac com/

ENTRYPOINT [ "java", "-jar", "app.jar" ]