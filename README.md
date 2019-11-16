# Springboot Microservice communication using MySql on Docker


docker build -t conusmer .
docker build -t producer .
docker network create consumer-producer
docker container run --network consumer-producer --name producer -p 8088:8088 producer &
docker container run --network consumer-producer --name consumer -p 8087:8087 consumer &


#some useful commands
docker ps -a
docker container stop consumer
docker rm consumer
docker network ls
