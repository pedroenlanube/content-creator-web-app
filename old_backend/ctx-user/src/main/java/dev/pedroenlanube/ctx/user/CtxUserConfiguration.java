package dev.pedroenlanube.ctx.user;

import dev.pedroenlanube.awscloud.config.EnableCloudInfrastructure;
import dev.pedroenlanube.domain.application.config.EnableDomainUserUseCases;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableCloudInfrastructure
@EnableDomainUserUseCases
public class CtxUserConfiguration {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CtxUserConfiguration.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
