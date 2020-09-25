# helloworld

How to start the helloworld application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/helloworld-1.0-SNAPSHOT.jar server config.yml`
3. To check that your application is running enter url `http://localhost:8080`

Run with Docker
-----
1. Run `mvn clean install` to build your application
2. `sudo docker build -t dropwizard-helloworld .`
3. `sudo docker run -d -p 8080:8080 dropwizard-helloworld`


Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
