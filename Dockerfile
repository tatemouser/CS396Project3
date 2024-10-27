# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY src/ /app/src/
COPY bin/ /app/bin/
COPY libs/ /app/libs/

RUN ls /app/bin
RUN find /app/src -name "*.java" | xargs javac -cp "/app/libs/junit-4.13.2.jar" -d /app/bin -verbose



# Set the command to run your application
# THIS DOES NOT WORK for some reason
CMD ["java", "-cp", "/app/bin/", "main.MainApplication", "-verbose:class"]