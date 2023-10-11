FROM amazoncorretto:21.0.0-alpine3.18

WORKDIR /app

COPY build/libs/CBS-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]