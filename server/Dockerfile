### BUILD image
FROM maven:3-jdk-11 as builder
# create app folder for sources
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
# Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins
# Copy source code
COPY src /build/src
# Build application
RUN mvn -Dmaven.test.skip=true package

### Runtime image
FROM openjdk:12-alpine as runtime
# Expose port 8080
EXPOSE 8080
# Set app home folder
ENV APP_HOME /app
# Create base app folder
RUN mkdir $APP_HOME
# Create folder to save configuration files
RUN mkdir $APP_HOME/config
# Create folder with application logs
RUN mkdir $APP_HOME/log
VOLUME $APP_HOME/log
VOLUME $APP_HOME/config
WORKDIR $APP_HOME
# Copy executable jar file from the builder image
COPY --from=builder /build/target/*.jar thundershare.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=docker","-jar","thundershare.jar"]