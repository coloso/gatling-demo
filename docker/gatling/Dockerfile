FROM alpine:3.11

LABEL maintainer="Janosch Kocsis <jk@coloso.de>"

RUN apk add --update openjdk8-jre

ENV SCALA_VERSION=2.12.8\
    SCALA_HOME=/usr/share/scala

# NOTE: bash is used by scala/scalac scripts, and it cannot be easily replaced with ash.
RUN apk add --no-cache --virtual=.build-dependencies wget ca-certificates && \
    apk add --no-cache bash curl jq && \
    cd "/tmp" && \
    wget --no-verbose "https://downloads.typesafe.com/scala/${SCALA_VERSION}/scala-${SCALA_VERSION}.tgz" && \
    tar xzf "scala-${SCALA_VERSION}.tgz" && \
    mkdir "${SCALA_HOME}" && \
    rm "/tmp/scala-${SCALA_VERSION}/bin/"*.bat && \
    mv "/tmp/scala-${SCALA_VERSION}/bin" "/tmp/scala-${SCALA_VERSION}/lib" "${SCALA_HOME}" && \
    ln -s "${SCALA_HOME}/bin/"* "/usr/bin/" && \
    apk del .build-dependencies && \
    rm -rf "/tmp/"*

RUN export PATH="/usr/local/sbt/bin:$PATH" && apk update && apk add ca-certificates wget tar && mkdir -p "/usr/local/sbt" && wget -qO - --no-check-certificate "https://piccolo.link/sbt-0.13.16.tgz" | tar xz -C /usr/local/sbt --strip-components=1 && sbt sbtVersion

WORKDIR /opt

ENV GATLING_VERSION 3.3.1
RUN mkdir -p gatling

RUN apk add --update wget && \
  apk add --update bash libc6-compat &&\
  mkdir -p /tmp/downloads && \
  wget -q -O /tmp/downloads/gatling-$GATLING_VERSION.zip \
  https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/$GATLING_VERSION/gatling-charts-highcharts-bundle-$GATLING_VERSION-bundle.zip && \
  mkdir -p /tmp/archive && cd /tmp/archive && \
  unzip /tmp/downloads/gatling-$GATLING_VERSION.zip && \
  mv /tmp/archive/gatling-charts-highcharts-bundle-$GATLING_VERSION/* /opt/gatling/

WORKDIR  /opt/gatling

VOLUME ["/opt/gatling/conf", "/opt/gatling/results", "/opt/gatling/user-files"]

ENV PATH /opt/gatling/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
ENV GATLING_HOME /opt/gatling

COPY MyFirstLoadtest.scala /user-files/simulations/MyFirstLoadtest.scala

ENTRYPOINT ["gatling.sh"]