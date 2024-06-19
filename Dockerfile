# Use the official image as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable jar file into the container
COPY . /app

CMD ["gradle", "bootRun"]