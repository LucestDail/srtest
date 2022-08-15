FROM openjdk:17-jdk-alpine

RUN sudo apt update

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]