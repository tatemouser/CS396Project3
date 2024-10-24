# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY src/ /app/src
COPY bin/ /app/bin
COPY libs/ /app/libs

# Compile the Java application (assuming javac is used to compile manually)
RUN javac -d /app/bin /app/src/main/healthcare/**/*.java



# Set the command to run your application
CMD ["java", "-cp", "/app/bin:/app/libs/*", "main.healthcare.HealthcareApplication"]