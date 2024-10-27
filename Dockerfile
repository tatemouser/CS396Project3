# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY src/ /app/src
COPY bin/ /app/bin
COPY libs/ /app/libs

RUN javac -d /app/bin/ /app/src/**/*.java -verbose


# Set the command to run your application
# THIS DOES NOT WORK for some reason
CMD ["java", "-cp", "app/bin/", "main.MainApplication", "-verbose:class"]