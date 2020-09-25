FROM openjdk:11

EXPOSE 8080
EXPOSE 8081

ADD target/helloworld-1.0-SNAPSHOT.jar helloworld.jar
ADD helloworld.yml helloworld.yml

CMD ["java", "-jar", "helloworld.jar", "server", "helloworld.yml"]