package dev.pedroenlanube.domain.application.user;

import dev.pedroenlanube.domain.core.port.in.user.RegisterUserUseCase;
import dev.pedroenlanube.domain.core.port.out.user.SaveUserPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class UserUseCasesConfigurationTest {

    @Test
    void shouldRegisterUserUseCasesBeans() {
        // 1. Mockeamos el puerto (la infraestructura)
        SaveUserPort mockSaveUserPort = mock(SaveUserPort.class);

        // 2. Instanciamos la configuración
        UserUseCasesConfiguration configuration = new UserUseCasesConfiguration();

        // 3. Ejecutamos el método productor
        RegisterUserUseCase useCase = configuration.registerUserUseCase(mockSaveUserPort);

        // 4. Verificamos que se ha creado correctamente
        assertThat(useCase).isNotNull();
    }
}