FROM openjdk:17.0.2-oracle
ADD target/simple-spring-docker-app-1.0.0.jar simple-spring-docker-app-1.0.0.jar
EXPOSE 8443

ENTRYPOINT ["java", "-jar", "simple-spring-docker-app-1.0.0.jar"]
