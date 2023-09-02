FROM adoptopenjdk/maven-openjdk17
COPY target/inventories-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8097:8097
ENTRYPOINT ["java","-jar","app.jar"]