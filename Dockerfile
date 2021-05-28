FROM openjdk:11

ARG PROFILE
ARG ADITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADITIONAL_OPTS=${ADITIONAL_OPTS}

WORKDIR /opt/resilire

COPY /target/resilire-*.jar resilire-0.0.1-SNAPSHOT.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar resilire.jar --spring.profiles.active=${PROFILE}