package dev.pedroenlanube.ctx.user.adapter.in.lambda;

import com.amazonaws.services.lambda.runtime.events.CognitoUserPoolPostConfirmationEvent;
import dev.pedroenlanube.domain.core.model.user.User;
import dev.pedroenlanube.domain.core.port.in.user.RegisterUserUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CognitoPostConfirmationLambdaTest {

    @Mock
    private RegisterUserUseCase registerUserUseCase;

    @Test
    void shouldMapEventAndTriggerUseCase() {
        // Arrange
        CognitoPostConfirmationLambda config = new CognitoPostConfirmationLambda();
        var function = config.postConfirmation(registerUserUseCase);

        CognitoUserPoolPostConfirmationEvent event = createMockEvent();

        // Act
        var result = function.apply(event);

        // Assert
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(registerUserUseCase, times(1)).accept(userCaptor.capture());

        User savedUser = userCaptor.getValue();
        assertNotNull(savedUser);
        assertEquals(event, result);
    }

    private CognitoUserPoolPostConfirmationEvent createMockEvent() {
        return CognitoUserPoolPostConfirmationEvent.builder()
                .withUserPoolId("eu-west-1_xxxxxxxxx")
                .withUserName("test-user-id")
                .withRequest(CognitoUserPoolPostConfirmationEvent.Request.builder()
                        .withUserAttributes(Map.of(
                                "sub", "user-sub-id1",
                                "email", "pedro@example.com"
                        ))
                        .build())
                .build();
    }
}
