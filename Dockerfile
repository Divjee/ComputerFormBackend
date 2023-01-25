FROM openjdk:18-alpine
COPY target/ComputerPartsForm-0.0.1-SNAPSHOT.jar /app/myapp.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/myapp.jar"]



