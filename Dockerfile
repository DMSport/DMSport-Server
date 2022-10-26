FROM openjdk:11-jre-slim
ENV TZ=Asia/Seoul
ARG JAR_FILE=./build/libs/DMSport-server-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
