FROM openjdk:8
ADD target/docker-minikube.jar docker-minikube.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","docker-minikube.jar"]