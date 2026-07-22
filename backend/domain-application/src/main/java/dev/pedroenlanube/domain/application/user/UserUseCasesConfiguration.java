package dev.pedroenlanube.domain.application.user;

import dev.pedroenlanube.domain.core.port.in.user.RegisterUserUseCase;
import dev.pedroenlanube.domain.core.port.out.user.SaveUserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCasesConfiguration {

    @Bean
    public RegisterUserUseCase registerUserUseCase(SaveUserPort saveUserPort) {
        return saveUserPort::accept;
    }
}
