package com.ameya.dropwizard;

import com.ameya.dropwizard.health.TemplateHealthCheck;
import com.ameya.dropwizard.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class HelloworldApplication extends Application<HelloworldConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloworldApplication().run(args);
    }

    @Override
    public String getName() {
        return "helloworld";
    }

    @Override
    public void initialize(final Bootstrap<HelloworldConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new SwaggerBundle<HelloworldConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(HelloworldConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(final HelloworldConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
