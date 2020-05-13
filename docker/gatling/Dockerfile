#FROM openjdk:8-jdk-alpine
#FROM openjdk:11-alpine
#FROM alpine:3.11
FROM openjdk:8-alpine
ENV GATLING_VERSION 3.2.1

RUN apk --update --no-cache add openjdk8 wget

RUN mkdir -p /opt/gatling

RUN wget -q -O gatling-${GATLING_VERSION}.zip https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/${GATLING_VERSION}/gatling-charts-highcharts-bundle-${GATLING_VERSION}-bundle.zip && \
    unzip gatling-${GATLING_VERSION}.zip && \
    mv gatling-charts-highcharts-bundle-${GATLING_VERSION}/* /opt/gatling

ENV GATLING_HOME /opt/gatling
ENV PATH="$PATH:/opt/gatling/bin"

ENTRYPOINT ["gatling.sh"]
CMD ["-s computerdatabase.BasicSimulation"]
#ENTRYPOINT ["/opt/gatling/bin/gatling.sh"]
#CMD ["--help"]

#CMD ["/opt/gatling/bin/gatling.sh"]
#CMD ["/usr/bin/java", "-version"]
