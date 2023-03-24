FROM openjdk:17-jdk-alpine

EXPOSE 8082

ARG JAR_FILE=target/order-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT exec java -jar /app.jar