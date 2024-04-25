FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/hw6-0.0.1.jar hw6.jar
ENTRYPOINT ["java", "-jar", "hw6.jar"]