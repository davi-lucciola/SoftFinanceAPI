# Multstage Build
# First Image are to Build Image
FROM gradle:8.2.1 AS builder
ENV APP_HOME=/usr/app
WORKDIR ${APP_HOME}
COPY build.gradle settings.gradle gradlew ${APP_HOME}
COPY . .
RUN gradle build --no-daemon


# Second Image are to run de Application
FROM openjdk:17
ENV APP_HOME=/usr/app
COPY --from=builder ${APP_HOME}/build/libs/softfinance-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "softfinance-0.0.1-SNAPSHOT.jar"]