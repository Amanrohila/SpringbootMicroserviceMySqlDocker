FROM openjdk:8
ADD target/DockerConsumer.jar DockerConsumer.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","/DockerConsumer.jar"]
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/DockerConsumer.jar"]