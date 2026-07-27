package dev.pedroenlanube.domain.application.user;

import dev.pedroenlanube.domain.core.port.in.user.RegisterUserUseCase;
import dev.pedroenlanube.domain.core.port.out.user.SaveUserPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@Dependent
public class UserUseCasesConfiguration {

    @Produces
    @ApplicationScoped
    public RegisterUserUseCase registerUserUseCase(SaveUserPort saveUserPort) {
        return saveUserPort::accept;
    }
}
