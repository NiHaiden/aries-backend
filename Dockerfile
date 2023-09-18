FROM gradle:7.6-jdk17-alpine AS build
RUN mkdir -p /home/aries
COPY --chown=gradle:gradle . /home/aries/src
WORKDIR /home/aries/src
RUN gradle bootJar --no-daemon

FROM eclipse-temurin:17.0.7_7-jre-jammy
LABEL authors="Niklas Haiden"

RUN mkdir /aries
WORKDIR /aries
COPY --from=build /home/aries/src/build/libs/*.jar /aries/aries-backend.jar

EXPOSE 8080
CMD ["java", "-jar", "/aries/aries-backend.jar"]
