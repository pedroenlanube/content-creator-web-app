package dev.pedroenlanube.cloudinfrastructurecommons.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.ssm.SsmClient;

@Configuration
public class AwsConfig {

    @Bean
    public SsmClient ssmClient() {
        return SsmClient.builder().build();
    }
}
