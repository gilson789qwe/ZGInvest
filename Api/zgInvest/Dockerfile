#COMANDO
# sudo chmod +x mvnw
#docker build -t zginvest .
#docker run -p 8080:8080 -t zginvest

FROM amazoncorretto:17-alpine-jdk
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]

