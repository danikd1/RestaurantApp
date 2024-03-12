FROM openjdk:12-jdk-alpine

RUN apk add --no-cache bash

WORKDIR /restaurantappbrat

CMD ./gradlew run