FROM eclipse-temurin:17.0.7_7-jre-jammy
LABEL authors="Niklas Haiden"

RUN mkdir /opt/app
COPY aries-backend.jar /opt/app/aries-backend.jar

EXPOSE 8080
CMD ["java", "-jar", "/opt/app/aries-backend.jar"]
