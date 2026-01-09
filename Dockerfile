# Step 1: Build con Grandle 9.2.1 y JDK 21 (compilacion)
FROM gradle:9.2.1-jdk21 as build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar --no-daemon

# Step 2: Runtime con JDK 21
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar platzi_play.jar
EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "jar", "platzi_play.jar"]