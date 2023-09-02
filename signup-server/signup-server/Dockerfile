FROM adoptopenjdk/maven-openjdk17
COPY target/signup-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8094:8094
ENTRYPOINT ["java","-jar","app.jar"]