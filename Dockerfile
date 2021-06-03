FROM adoptopenjdk/openjdk11:jdk-11.0.7_10-alpine-slim

WORKDIR /opt
COPY . .
RUN ./gradlew build
WORKDIR build/libs

CMD ["java", "-jar", "dominator-1.0.0.jar"]
