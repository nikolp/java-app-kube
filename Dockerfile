FROM amazoncorretto:17

WORKDIR /app

COPY target/appkube-1.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]