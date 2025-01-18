# Use an official OpenJDK image based on Alpine Linux for a lightweight container
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container to /app
# All subsequent commands will be executed from this directory
WORKDIR /dbms

# Copy all the project files from the host machine to the /app directory in the container
COPY . /dbms

# Compile the Java program (CDBMS.java) inside the container
# The compiled output (CDBMS.class) will be created in the same directory
RUN javac CDBMS.java

# Define the command to run the program when the container starts
# This will run the Java program CDBMS
ENTRYPOINT ["java", "CDBMS"]
