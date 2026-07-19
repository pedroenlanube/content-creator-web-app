package dev.pedroenlanube.ctx.user.application.service;

import dev.pedroenlanube.domain.port.in.user.RegisterUserUseCase;
import dev.pedroenlanube.domain.port.out.user.SaveUserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterUseFromCognitoService {

    @Bean
    public RegisterUserUseCase registerUserUseCase(SaveUserPort saveUserPort) {
        return saveUserPort::accept;
    }
}
