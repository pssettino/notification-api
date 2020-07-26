FROM openjdk:8 as Target
COPY build/libs/notification-api-0.0.1.jar notification-api.jar

ENTRYPOINT ["java","-jar","/notification-api.jar"]

EXPOSE 9093
