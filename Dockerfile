FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/hw9-0.0.1.jar hw9.jar
ENTRYPOINT ["java", "-jar", "hw9.jar"]