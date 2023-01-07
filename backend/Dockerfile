FROM maven:3.8.6-openjdk-18 AS MAVEN
WORKDIR /tmp
COPY /src/ ./src
COPY /pom.xml ./
RUN mvn package

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/tmp/target/*.jar
COPY --from=MAVEN ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
