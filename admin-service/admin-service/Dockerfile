FROM adoptopenjdk/maven-openjdk17
COPY target/admin-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8095:8095
ENTRYPOINT ["java","-jar","app.jar"]