#COMANDO
#sudo docker build -t zginvest .
#sudo docker run -p 8080:8080 -t zginvest

FROM eclipse-temurin:17-jdk-focal
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]

