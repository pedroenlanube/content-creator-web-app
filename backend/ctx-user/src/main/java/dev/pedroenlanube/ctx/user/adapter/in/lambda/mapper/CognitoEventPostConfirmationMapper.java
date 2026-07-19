package dev.pedroenlanube.ctx.user.adapter.in.lambda.mapper;

import com.amazonaws.services.lambda.runtime.events.CognitoUserPoolPostConfirmationEvent;
import dev.pedroenlanube.domain.model.user.User;
import dev.pedroenlanube.domain.model.user.vo.Email;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CognitoEventPostConfirmationMapper {
    public static final Function<CognitoUserPoolPostConfirmationEvent, User> toDomain =
            event -> Optional.ofNullable(event)
                    .map(CognitoEventPostConfirmationMapper::extractUser)
                    .orElse(null);

    private static User extractUser(CognitoUserPoolPostConfirmationEvent event) {
        Map<String, String> attributes = event.getRequest().getUserAttributes();

        String sub = attributes.get("sub");
        String email = attributes.get("email");
        String username = event.getUserName();

        return new User(sub, username, new Email(email));
    }
}
