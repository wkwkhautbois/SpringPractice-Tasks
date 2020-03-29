FROM adoptopenjdk/openjdk11
EXPOSE 8080
WORKDIR /opt/app/
ADD ./tasks-back/target/tasks-0.0.1-SNAPSHOT.jar /opt/app/

RUN sh -c 'touch /opt/app/tasks-0.0.1-SNAPSHOT.jar'
ENTRYPOINT [ "sh", "-c", "java -jar /opt/app/tasks-0.0.1-SNAPSHOT.jar" ]