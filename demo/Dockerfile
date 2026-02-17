# ---------- STAGE 1 : BUILD ----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy entire project
COPY demo ./demo

WORKDIR /app/demo

# Build jar
RUN mvn clean package -DskipTests


# ---------- STAGE 2 : RUN ----------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /app/demo/target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]
