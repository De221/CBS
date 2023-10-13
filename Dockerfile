FROM amazoncorretto:21.0.0-alpine3.18

WORKDIR /app

COPY gradlew .
COPY gradlew.bat .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src

COPY build/libs/CBS-0.0.1-SNAPSHOT.jar app.jar
COPY entrypoint.sh entrypoint.sh

#EXPOSE 8080
#CMD ["java", "-jar", "app.jar"]
ENTRYPOINT ["sh", "entrypoint.sh"]
