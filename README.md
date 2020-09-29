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

Steps followed

1. For setting up a basic dropwizard app we use maven archetype and type the following
code in your terminal. The below command is something like spring initializr and will
quickly scaffold a basic dropwizard app for you.
```bash
mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=2.0.13
```
Give the required details as the above command will run in interactive mode. 

2. Now write the code inside the newly generated pacakge(dropwizard app).

3. To add swagger bundle to the dropwizard app, use the following steps. We are adding
swagger bundle to dropwizard, because adding this bundle(which takes a small number of steps)
allows us to package the swagger UI along with the jar file. The SwaggerUI allows us to 
look at the API contract, call test the APIs all within the browser. Furthermore the 
Swagger CodeGen allows us to use any other API by just using their swagger.json/yaml file.
For more information watch [this video](https://www.youtube.com/watch?v=QQaFKGU8oi4).
It shows how easy it is to consume API created by others. Typically when other create 
their own API they also have to create their own models. API consumers will then import 
this model package into their package. This will allow them to use the rre defined request
response objects. Swagger CodeGen can create the request response objects by using
only a swagger.json/yaml file. 

    1. Follow instructions provided here : https://github.com/smoketurner/dropwizard-swagger

    2. Crown every resource class with @Api annotation provided by swagger bundle
    
    3. Annotate all functions inside the resource class with usefull annotations provided
        by swagger.
        
    4. Use /swagger endpoint to view the swagger ui.

