FROM adoptopenjdk/maven-openjdk11
MAINTAINER kubilaycicek
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} afad-api-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/afad-api-0.0.1-SNAPSHOT.jar"]

