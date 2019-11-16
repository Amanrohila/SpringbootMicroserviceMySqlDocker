FROM openjdk:8
ADD target/DockerProducer.jar DockerProducer.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/DockerProducer.jar"]