FROM openjdk:8-alpine

LABEL maintainer="Janosch Kocsis <jk@coloso.de>"

ENV GATLING_VERSION 3.2.1

RUN apk add --update wget

RUN mkdir -p /opt/gatling

RUN wget -q -O gatling-${GATLING_VERSION}.zip https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/${GATLING_VERSION}/gatling-charts-highcharts-bundle-${GATLING_VERSION}-bundle.zip && \
    unzip gatling-${GATLING_VERSION}.zip && \
    mv gatling-charts-highcharts-bundle-${GATLING_VERSION}/* /opt/gatling

ENV GATLING_HOME /opt/gatling
ENV PATH="$PATH:/opt/gatling/bin"

ARG SCALA
ENTRYPOINT ["gatling.sh" , "-s" , "${SCALA}"]
#CMD ["--help"]