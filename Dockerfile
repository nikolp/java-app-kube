FROM openjdk:17-jdk

WORKDIR /app

COPY target/appkube-1.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]