FROM adoptopenjdk/maven-openjdk17
COPY target/payment-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8098:8098
ENTRYPOINT ["java","-jar","app.jar"]