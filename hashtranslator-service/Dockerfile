FROM openjdk:17 AS builder
WORKDIR /app
COPY gradle/ gradle/
COPY gradlew build.gradle settings.gradle ./
RUN ./gradlew --no-daemon dependencies
COPY src/ src/
RUN ./gradlew --no-daemon build

FROM openjdk:17
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "/app/hashtranslator.jar"]
COPY --from=builder /app/build/libs/hashtranslator-*.jar hashtranslator.jar