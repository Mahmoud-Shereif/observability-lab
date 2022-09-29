FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=target/observability-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /observability-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/observability-0.0.1-SNAPSHOT.jar"]
