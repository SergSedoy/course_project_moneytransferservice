FROM openjdk:8-jdk-alpine
EXPOSE 5500
ADD build/libs/course_project_moneytransferservice-0.0.1-SNAPSHOT.jar transferservice.jar
ENTRYPOINT ["java", "-jar", "transferservice.jar"]
