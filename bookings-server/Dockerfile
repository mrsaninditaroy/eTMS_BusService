FROM adoptopenjdk/maven-openjdk17
COPY target/booking-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8096:8096
ENTRYPOINT ["java","-jar","app.jar"]