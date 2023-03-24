FROM openjdk:11

MAINTAINER kubilaycicek

COPY target/afad-api-0.0.1-SNAPSHOT.jar .

WORKDIR /usr/app

EXPOSE 8080

ENTRYPOINT ["java","-jar","usr/app/afad-api-0.0.1-SNAPSHOT.jar"]