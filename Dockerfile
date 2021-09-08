FROM alpine:3.2

ENV TZ 'Asia/Seoul'
ENV JAVA_OPTS=""
ENV DOC_ROOT /crmTestExample
ENV VER=1.0
ENV LANG en_US.UTF-8
ENV LANGUAGE  en_US:en

RUN apk add curl && \
    apk add vim && \
    apk add zip && \
    apk add unzip

RUN mkdir -p /crmTestExample \
             /Logs

ADD ./target/crmTestExample-0.0.1.war   /crmTestExample/crmTestExample-0.0.1.war

VOLUME /tmp /crmTestExample

USER root
ENV TZ 'Asia/Seoul'
RUN echo $TZ > /etc/timezone


EXPOSE 80

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar  /crmTestExample/crmTestExample-0.0.1.war" ]


