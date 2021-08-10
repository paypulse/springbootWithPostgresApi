#JDK
FROM java:8

#실행 경로
WORKDIR /etc/

ARG JAR_FILE=target/crmTestExample-0.0.1.war

COPY ${JAR_FILE} app.war





