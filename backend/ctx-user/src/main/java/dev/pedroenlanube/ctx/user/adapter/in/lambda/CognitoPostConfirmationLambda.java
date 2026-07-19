package dev.pedroenlanube.ctx.user.adapter.in.lambda;

import com.amazonaws.services.lambda.runtime.events.CognitoUserPoolPostConfirmationEvent;
import dev.pedroenlanube.ctx.user.adapter.in.lambda.mapper.CognitoEventPostConfirmationMapper;
import dev.pedroenlanube.domain.port.in.user.RegisterUserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.function.Function;

@Slf4j
@Configuration
public class CognitoPostConfirmationLambda {

    public Function<CognitoUserPoolPostConfirmationEvent, CognitoUserPoolPostConfirmationEvent>
    postConfirmation(RegisterUserUseCase registerUserUseCase) {
        return event -> Optional.ofNullable(event)
                .map(CognitoEventPostConfirmationMapper.toDomain)
                .map(user -> {
                    log.info("Saving user: {}", user);
                    registerUserUseCase.accept(user);
                    return event;
                })
                .orElse(event);
    }
}
