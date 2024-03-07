FROM openjdk:21-jdk
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ./target/Game-0.0.1-SNAPSHOT app.jar
ENTRYPOINT ["java","-jar","/app.jar"]