FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} product-service.jar
ENTRYPOINT ["java","-jar","/product-service.jar"]
EXPOSE 9090