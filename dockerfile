# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY build/libs/jtsolv-spring-kafka-gamedices-consumer-0.0.31-SNAPSHOT.jar jtsolv-spring-kafka-gamedices-consumer-0.0.31.jar

# Expose ports (8080 for REST API)
EXPOSE 8080

# Environment variables for Kafka broker
ENV KAFKA_BROKER=kafka-service:9092

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "jtsolv-spring-kafka-gamedices-consumer-0.0.31.jar"]
