# FROM Java Open JDK Apline
FROM openjdk:8-jre-alpine

#Maintainer Saad
MAINTAINER saad ahmed<pheonix158@gmail.com>

COPY target/demo-0.0.1-SNAPSHOT.jar /inmeoryh2.jar

CMD ["java", "-jar" , "/inmeoryh2.jar" ]

