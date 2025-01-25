FROM openjdk:17-jdk

WORKDIR /app

COPY target/api-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]

EXPOSE 8080