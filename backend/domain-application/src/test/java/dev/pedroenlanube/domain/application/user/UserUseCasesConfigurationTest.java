package dev.pedroenlanube.domain.application.user;

import dev.pedroenlanube.domain.core.port.in.user.RegisterUserUseCase;
import dev.pedroenlanube.domain.core.port.out.user.SaveUserPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class UserUseCasesConfigurationTest {

    // 1. Mock the infrastructure part (what would normally come from cloud-infrastructure-common)
    @Configuration
    static class MockInfrastructureConfig {
        @Bean
        public SaveUserPort saveUserPort() {
            return mock(SaveUserPort.class);
        }
    }

    // 2. Prepare the runner with your real configuration and the mocked infrastructure
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(UserUseCasesConfiguration.class)
            .withUserConfiguration(MockInfrastructureConfig.class);

    @Test
    void shouldRegisterUserUseCasesBeans() {
        contextRunner.run(context -> {
            // Verify that the Spring context starts cleanly, without circular dependencies or missing beans
            assertThat(context).hasNotFailed();

            // Verify that the use case is registered and ready to be injected into the Lambda
            assertThat(context).hasSingleBean(RegisterUserUseCase.class);

            // Optional: if you have multiple use cases in this configuration, assert them here
            // assertThat(context).hasSingleBean(UpdateUserUseCase.class);
        });
    }
}