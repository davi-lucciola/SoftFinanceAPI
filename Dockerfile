# Multstage Build
# First Image are to Build Image
FROM gradle:8.2.1-jdk17 AS builder
ENV APP_HOME=/usr/app
WORKDIR ${APP_HOME}
COPY build.gradle settings.gradle gradlew ${APP_HOME}
COPY . .
RUN gradle build --no-daemon


# Second Image are to run de Application
FROM openjdk:17
ENV APP_HOME=/usr/app
WORKDIR ${APP_HOME}
COPY --from=builder ${APP_HOME}/build .
EXPOSE 8080
CMD ["java", "-jar", "libs/softfinance.jar"]