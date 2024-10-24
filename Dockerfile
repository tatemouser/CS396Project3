# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY src/ /app/src
COPY bin/ /app/bin
COPY libs/ /app/libs

RUN javac -d /app/bin src/models/*.java src/services/*.java src/main/*.java


# Set the command to run your application
CMD ["java", "-cp", "app/bin", "main.MainApplication"]