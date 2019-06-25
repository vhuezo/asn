#FROM ptoreg.tigo.net.bo/htc/oracle-jdk:8u171
#FROM registry.gitlab.com/vhuezo/oracle-jdk/centos7:8u131
FROM registry.gitlab.com/vhuezo/oracle-jdk:latest
#FROM registry.gitlab.com/vhuezo/oracle-jdk/centos7:8u131

ARG JAR
ARG YML

ENV  VERSION=$VERSION \
     LOG_BASE="/app/logback" \
     PROP_BASE="/app/production" \
     APP_BASE="/app/" \
     JAR_FILE=$JAR \
     LOG_FILE=logback.xml \
     PROP_FILE=$YML

WORKDIR $APP_BASE
RUN chmod 755 /app && chown -R nobody:nobody /app

COPY ./build/libs/*.jar $APP_BASE/$JAR_FILE
 COPY $PROP_FILE $PROP_BASE/
# COPY *.xml $LOG_BASE/$LOG_FILE

#HEALTHCHECK --interval=1m CMD  curl --fail --silent  localhost:8035/ggsn/env || exit 1

USER nobody

#Command to execute the Java App Docker
CMD java -Dserver.port=$PORT -Dapp.log=/app/log -Dapp.env=$ENVIRONMENT -Dspring.config.location=$PROP_BASE/$PROP_FILE -Duser.timezone=America/La_Paz -jar $JAR_FILE 

#YML = -Dspring.config.location=$PROP_BASE/$PROP_FILE
#XML =  -Dlogging.config=$LOG_BASE/$LOG_FILE 