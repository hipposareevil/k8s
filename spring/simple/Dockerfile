FROM openjdk:8-jdk-alpine

# Basics
RUN apk --no-cache add curl bash


ARG JAR_FILE
COPY target/${JAR_FILE} app.jar

COPY entrypoint.sh docker-run.sh
ENTRYPOINT ["/bin/bash","/docker-run.sh"]
