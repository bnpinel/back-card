FROM openjdk:8-jdk-alpine

ARG version
ARG jarname

COPY target/$jarname-$version.jar /data/$jarname-$version.jar

ENV full_jarname=/data/$jarname-$version.jar

EXPOSE 9093

CMD java -jar ${full_jarname}
